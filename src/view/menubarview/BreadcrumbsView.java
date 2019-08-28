package view.menubarview;

import app.Sheet;
import app.SheetListener;
import app.SheetState;
import itemsmodel.Directory;
import itemsmodel.DirectoryAttr;
import itemsmodel.Item;
import tool.Lam2UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BreadcrumbsView extends JToolBar
        implements SheetListener, ActionListener {
    private Sheet sheet;
    private List<Item>parents;
    private List<String>accos=new ArrayList<>();

    public BreadcrumbsView(Sheet sheet){
        super();
        this.sheet=sheet;
        sheet.addSheetListener(this);
        Lam2UI.makeUpContainer(this);
        this.setFloatable(false);
        setBackground(Lam2UI.gray1);
    }

    @Override
    public void sheetChanged() {
        if(sheet.getState()== SheetState.Showing){
            removeAll();
            parents=sheet.getHierarchy();
            int numParent=parents.size();
            accos=new ArrayList<>(numParent);

            for(int i=0;i<numParent;i++){
                JButton button= Lam2UI.getButton();
                button.setBackground(Lam2UI.gray2);
                Directory dir=(Directory)parents.get(i);
                String text=(String)dir.getAttr(DirectoryAttr.Title.toString());
                String acco=Integer.toString(i);

                accos.add(acco);
                button.setText(text);
                button.addActionListener(this);
                button.setActionCommand(acco);
                add(button);
                addSeparator();
            }
        }
        updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acco=e.getActionCommand();
        for(int i=0;i<accos.size();i++){
            if(accos.get(i).equals(acco)){
                sheet.setNowDirectory((Directory)parents.get(i));
            }
        }
    }
}
