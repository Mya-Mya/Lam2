package view.sheetview;

import app.Sheet;
import app.SheetListener;
import itemsmodel.Directory;
import itemsmodel.Item;
import itemsmodel.Product;
import tool.Lam2Constants;
import tool.Lam2UI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SheetContentsView extends JPanel implements SheetListener {
    private Sheet mySheet;

    public SheetContentsView(Sheet firstSheet) {
        this.mySheet = firstSheet;
        this.mySheet.addSheetListener(this);
        Lam2UI.makeUpContainer(this);
        initLoadingComponents();
    }

    /**
     * モデルの読み込みが完了している場合に表示するコンポーネントの整備をする
     */
    protected void initShowingComponents() {
        removeAll();
        this.setLayout(new BorderLayout());
        FlowLayout fl=new FlowLayout(FlowLayout.LEFT);
        fl.setHgap(20);
        fl.setVgap(20);
        fl.setAlignOnBaseline(false);

        JPanel container = new JPanel(fl);
        Lam2UI.makeUpContainer(container);
        container.setPreferredSize(new Dimension(Lam2Constants.cntSize.width,0));

        JScrollPane scrollPane = new JScrollPane(
                container,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        Lam2UI.makeUpContainer(scrollPane);
        this.add(scrollPane,BorderLayout.CENTER);

        List<Item> items = mySheet.getChildList();
        for (Item i : items) {
            switch (i.getKind()) {
                case DIRECTORY:
                    container.add(new DirectoryView((Directory) i,mySheet));
                    break;
                case PRODUCT:
                    container.add(new ProductView((Product) i,mySheet));
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
        JLabel lLoading=Lam2UI.getLargeLabel();
        lLoading.setText("読み込み中");
        lLoading.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(lLoading, BorderLayout.CENTER);
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
