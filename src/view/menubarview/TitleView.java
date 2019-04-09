package view.menubarview;

import app.Sheet;
import app.SheetListener;

import javax.swing.*;

public class TitleView extends JPanel implements SheetListener {
    public TitleView(Sheet sheet){
        sheet.addSheetListener(this);
    }

    @Override
    public void sheetChanged() {

    }
}
