package view.sheetview;

import app.Sheet;
import app.SheetListener;
import itemsmodel.Directory;
import itemsmodel.Item;
import itemsmodel.Product;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SheetContentsView extends JPanel implements SheetListener {
    private Sheet mySheet;

    public SheetContentsView(Sheet firstSheet) {
        this.mySheet = firstSheet;
        this.mySheet.addSheetListener(this);
        initLoadingComponents();
    }

    /**
     * モデルの読み込みが完了している場合に表示するコンポーネントの整備をする
     */
    protected void initShowingComponents() {
        removeAll();
        this.setLayout(new BorderLayout());
        JPanel container = new JPanel(new GridLayout(3,-1));

        JScrollPane scrollPane = new JScrollPane(
                container,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        this.add(scrollPane,BorderLayout.CENTER);

        List<Item> items = mySheet.getChildList();
        for (Item i : items) {
            switch (i.getKind()) {
                case DIRECTORY:
                    container.add(new DirectoryView((Directory) i));
                    break;
                case PRODUCT:
                    container.add(new ProductView((Product) i));
                    break;
            }
        }

        validate();
    }

    /**
     * モデルの読み込みがされていない、されている途中に表示する
     * コンポーネントの整備をする。
     */
    protected void initLoadingComponents() {
        removeAll();
        add(new JLabel("読み込み中"), BorderLayout.CENTER);
        setVisible(true);
        validate();
    }


    @Override
    public void sheetChanged() {
        switch (mySheet.getState()) {
            case Unloaded:
            case Loading:
                initLoadingComponents();
                break;
            case Showing:
                initShowingComponents();
                break;
        }
    }
}
