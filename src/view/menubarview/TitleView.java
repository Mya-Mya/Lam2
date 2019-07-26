package view.menubarview;

import app.Sheet;
import app.SheetListener;
import app.SheetState;
import itemsmodel.DirectoryAttr;
import tool.Lam2UI;

import javax.swing.*;

public class TitleView extends JPanel implements SheetListener {
    private Sheet sheet;
    public TitleView(Sheet sheet){
        this.sheet=sheet;
        sheet.addSheetListener(this);
    }

    @Override
    public void sheetChanged() {
        if(sheet.getState()== SheetState.Showing){
            removeAll();
            JLabel lText= Lam2UI.getLargeLabel();
            lText.setText(
                    (String) sheet.getNowDirectory().getAttr(DirectoryAttr.Title.toString())
            );
            add(lText);
        }
        updateUI();
    }
}
