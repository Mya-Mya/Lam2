package app;

import itemsmodel.Directory;
import itemsmodel.DirectoryAttr;
import itemsmodel.Item;
import itemsmodel.ProductAttr;

import java.util.List;

/**
 * コマンドライン上でデバッグ作業をしやすいように{@code Sheet}をオーバーライドしたもの。
 * @author Miyaoka
 * @see app.Sheet
 */
public class Sheet4Debug extends Sheet {
    public Sheet4Debug(String firstItem) {
        super(firstItem);
    }

    public void showHierarchy() {
        List<Item> list = getHierarchy();
        StringBuilder out = new StringBuilder();
        for (Item i : list) {
            out.append(i.toString());
            if (i != nowDirectory) out.append(" > ");
        }
        System.out.println(out.toString());
    }

    public void showChildren() {
        if (getChildList() == null) return;
        int indx = 0;
        StringBuilder out = new StringBuilder();
        for (Item i : getChildList()) {
            out.append(indx);
            out.append(" : ");
            out.append(i.toString());
            out.append("\n");
            indx++;
        }
        System.out.println(out.toString());
    }

    public void goInto(int indx) {
        List<Item> itemList = getChildList();
        setNowDirectory((Directory) itemList.get(indx));
    }

    public void showAttrs() {
        StringBuilder out = new StringBuilder();

        out.append("Directory型\n名称：");
        out.append(nowDirectory.getAttr(DirectoryAttr.Title.toString()));
        out.append("\n");
        out.append("詳細：");
        out.append(nowDirectory.getAttr(DirectoryAttr.Detail.toString()));
        out.append("\n");
        out.append("容量数：");
        out.append(((List) nowDirectory.getAttr(DirectoryAttr.List.toString())).size());
        out.append("\n");

        System.out.println(out.toString());
    }
}



