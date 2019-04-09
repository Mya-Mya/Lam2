package itemsmodel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 展示するアイテム一個体を表すスーパークラス。
 * アイテム一個体は一つのファイルシステム上のフォルダ空間を与えられ、
 * そこにあるファイルやフォルダを読み取って自身の属性を決定することが求められる。
 * @see itemsmodel.Directory
 * @see itemsmodel.Product
 */
public abstract class Item {
    protected File myDirectory;
    /**
     * 全ての属性はMapで管理する。キーは文字列型となっているため安全を保障する必要がある。
     */
    protected Map<String, Object> attrs;

    /**
     * 新しいアイテムを生成する。
     * @param directory 自分のアイテムを表すファイルディレクトリ
     */
    public Item(File directory) {
        this.myDirectory = directory;
        this.attrs = new HashMap<>();
    }

    /**
     * このアイテムの属性を取得する。
     * @param key キーとなる文字列（継承先でのキーの指定ルールに気を付けること）
     * @return キーに対応するオブジェクト
     */
    public final Object getAttr(String key) {
        return attrs.get(key);
    }

    /**
     * このアイテムの種類を取得する。
     * @return 種類
     */
    public ItemKind getKind() {
        return null;
    }


    /**
     * このアイテムの文字型表記を返す。
     * 継承してカスタマイズすること。
     * @return 文字列型表記
     */
    @Override
    public String toString() {
        return "Item";
    }
}
