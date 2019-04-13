package app;

import itemsmodel.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全作品とディレクトリのモデルを持ち、{@code view}と{@code itemsmodel}の架け橋となる。
 * 画面を構成するデータとサービスを提供する。
 * このインスタンス一つで様々な画面へ遷移することができるため、通常はアプリケーション内で一つだけ生成していればよい。
 * @author Miyaoka
 */
public class Sheet {
    protected SheetState state;
    protected String firstDirectoryPath;
    protected Directory nowDirectory;
    protected List<SheetListener> listeners;

    /**
     * 新しいシートを生成する。
     * @param rootDirectoryPath ルートとなるディレクトリを指すファイルパス
     */
    public Sheet(String rootDirectoryPath) {
        listeners=new ArrayList<>();
        this.firstDirectoryPath =rootDirectoryPath;
        this.state=SheetState.Unloaded;
    }
    /**
     * ルートディレクトリから読み込みを始めてモデルをすべて構築する。
     * この処理は時間がかかるため、視覚系クラスの整備が終わった後に実行すべきである。。
     */
    public void loadModels(){
        state=SheetState.Loading;
        fireListeners();
        File rootDirectory=new File(firstDirectoryPath);
        setNowDirectory(new Directory(rootDirectory,null));
        state=SheetState.Showing;
        fireListeners();
    }

    /**
     * 新しいカレントディレクトリを指定し、シート情報を更新する。
     * @param newDirectory 新しいカレントディレクトリ
     */
    public void setNowDirectory(Directory newDirectory) {
        this.nowDirectory = newDirectory;
        fireListeners();
    }

    /**
     * カレントディレクトリを出発点としてディレクトリの階層を取得する。
     * @return ディレクトリ階層が格納されたリスト
     */
    public List<Item> getHierarchy() {
        List<Item> out = new ArrayList<>();
        Directory parent = nowDirectory;
        while (true) {
            out.add(parent);
            if (parent.isTop()) break;
            parent = parent.getParent();
        }
        Collections.reverse(out);
        return out;
    }

    /**
     * カレントディレクトリの一つ上の親のディレクトリを取得する。
     * @return 一つ上の親のディレクトリ、カレントディレクトリが最上階層にある場合はnull
     */
    public Directory getParent() {
        if (nowDirectory.isTop()) {
            System.out.println("このアイテムが最上階層です");
            return null;
        }
        return nowDirectory.getParent();
    }

    /**
     * カレントディレクトリが持つ全てのアイテムを取得する。
     * 通常、アプリケーションではこの関数により得られるリストが画面に表示されるコンテンツとなる。
     * @return カレントディレクトリが持つ全てのアイテム
     */
    public List<Item> getChildList() {
        List<Item> childList = (List<Item>) nowDirectory.getAttr(DirectoryAttr.List.toString());
        return childList;
    }

    /**
     * カレントディレクトリを一つ上の親のディレクトリに更新する。
     * カレントディレクトリが最上階層にある場合は何もしない。
     */
    public void goUp() {
        if (nowDirectory.isTop()) {
            System.out.println("このアイテムが最上階層です");
            return;
        }
        setNowDirectory(getParent());
    }

    public Directory getNowDirectory() {
        return nowDirectory;
    }

    /**
     * シート情報が変更された時に通知を受け取るリスナーを追加する。
     * @param you リスナー通知を受け取りたいインスタンス
     */
    public void addSheetListener(SheetListener you) {
        this.listeners.add(you);
    }

    protected void fireListeners() {
        if(listeners.isEmpty())return;
        for (SheetListener l : listeners) l.sheetChanged();
    }

    public SheetState getState(){
        return state;
    }

}
