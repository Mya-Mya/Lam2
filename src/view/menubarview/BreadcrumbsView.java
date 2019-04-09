package view.menubarview;

import app.Sheet;
import app.SheetListener;

import javax.swing.*;

public class BreadcrumbsView extends JPanel implements SheetListener {
    public BreadcrumbsView(Sheet sheet){
        sheet.addSheetListener(this);
    }

    @Override
    public void sheetChanged() {

    }
}
