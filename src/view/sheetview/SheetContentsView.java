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
        init();
    }

    protected void init() {
        removeAll();
        JPanel container=new JPanel(new FlowLayout());
        List<Item> items = mySheet.getChildList();
        for (Item i : items) {
            switch (i.getKind()) {
                case DIRECTORY:
                    container.add(
                            new DirectoryView((Directory) i)
                    );
                    break;
                case PRODUCT:
                    container.add(
                            new ProductView((Product)i)
                    );
                    break;
            }
        }
        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(container);

        this.add(scrollPane);
        setVisible(true);
    }


    @Override
    public void sheetChanged() {
        repaint();
    }
}
