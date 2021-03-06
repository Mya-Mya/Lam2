package view.sheetview;

import app.Sheet;
import itemsmodel.Directory;
import itemsmodel.DirectoryAttr;
import itemsmodel.Item;
import tool.Lam2UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DirectoryView extends ItemView{
    private ButtonModel bt;
    public DirectoryView(Directory i, Sheet sheet) {
        super(i,sheet);
        setLayout(null);

        ImageIcon lIconData= (ImageIcon) i.getAttr(DirectoryAttr.Image.toString());
        JLabel lIcon= new JLabel(lIconData);
        lIcon.setBounds(0,0,200,200);

        JLabel lTitle=Lam2UI.getLargeLabel();
        lTitle.setText((String) i.getAttr(DirectoryAttr.Title.toString()));
        lTitle.setBounds(200,0,200,50);

        JLabel lDetail=Lam2UI.getNormalLabel();
        lDetail.setText((String) i.getAttr(DirectoryAttr.Detail.toString()));
        lDetail.setBounds(200,0,200,150);


        add(lIcon);
        add(lTitle);
        add(lDetail);

        setBackground(Lam2UI.sakura);
        bt=getModel();
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        if(bt.isRollover()){
            Graphics2D g2=(Graphics2D)g;
            g2.setPaint(Lam2UI.alphaUme);
            g2.fillRect(0,0,400,200);
        }else if(bt.isPressed()){
            Graphics2D g2=(Graphics2D)g;
            g2.setPaint(Lam2UI.alphaSumire);
            g2.fillRect(0,0,400,200);
        }
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        sheet.setNowDirectory((Directory) item);
        super.fireActionPerformed(event);
    }
}
