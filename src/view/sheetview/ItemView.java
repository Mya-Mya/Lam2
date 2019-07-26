package view.sheetview;

import app.Sheet;
import itemsmodel.Item;
import tool.Lam2Constants;
import tool.Lam2UI;

import javax.swing.*;
import java.awt.*;

public abstract class ItemView extends JButton {
    protected Sheet sheet;
    protected Item item;
    protected ItemViewListener listener;
    public ItemView(Item myItem,Sheet sheet,ItemViewListener listener){
        this.item=myItem;
        this.sheet=sheet;
        this.listener=listener;
        setPreferredSize(new Dimension(400,200));
        setBackground(Lam2UI.sakura);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(getModel().isRollover()){
            setPreferredSize(new Dimension(400,400));
            setSize(new Dimension(400,400));
            listener.itemViewRollChanged();
        }else{
            setPreferredSize(new Dimension(400,200));
            setSize(new Dimension(400,200));
            listener.itemViewRollChanged();
        }
        super.paintComponent(g);
    }
}
