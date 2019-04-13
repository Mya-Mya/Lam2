package itemsmodel;

import tool.Lam2Tool;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * アイテムを複数個所有するディレクトリクラス。
 * コンポジットパターンを適用している。
 * ディレクトリはその構造から基本的には親がいる。
 * @author Miyaoka
 * @see itemsmodel.DirectoryAttr
 * @see itemsmodel.Item
 */
public class Directory extends Item {
    Directory parent;

    @Override
    public ItemKind getKind() {
        return ItemKind.DIRECTORY;
    }

    /**
     * このディレクトリが名を返す
     * @return
     */
    @Override
    public String toString(){
        return (String) this.getAttr(DirectoryAttr.Title.toString());
    }

    public Directory(File directory, Directory parent) {
        super(directory);
        this.parent=parent;

        String title = this.myDirectory.getName();
        title = isTop()?"ようこそ":title.replaceAll("^.", "");//todo "items"の安全性
        this.attrs.put(ProductAttr.Title.toString(), title);

        List<Item> itemList = new ArrayList<>();
        Item newItem = null;
        for (File f : this.myDirectory.listFiles()) {
            if (f.getName().matches("^image\\..*$")) {
                ImageIcon image = new ImageIcon(f.toString());
                this.attrs.put(DirectoryAttr.Image.toString(), image);
            }
            if (f.getName().equals("detail.txt")) {
                this.attrs.put(DirectoryAttr.Detail.toString(),
                        Lam2Tool.readTextAll(f.toString()));
            }
            if (!f.isDirectory()) continue;
            if (f.getName().charAt(0) == ItemKind.DIRECTORY.getSign()) {
                newItem = new Directory(f, this);
            }
            if (f.getName().charAt(0) == ItemKind.PRODUCT.getSign()) {
                newItem = new Product(f);
            }
            itemList.add(newItem);
        }
        this.attrs.put(DirectoryAttr.List.toString(), itemList);
    }

    public Directory getParent(){
        return this.parent;
    }

    public boolean isTop(){
        return this.parent==null;
    }
}
