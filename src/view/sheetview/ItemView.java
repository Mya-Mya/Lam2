package view.sheetview;

import app.Sheet;
import itemsmodel.Item;
import tool.Lam2UI;

import javax.swing.*;
import java.awt.*;

public abstract class ItemView extends JButton {
    protected Sheet sheet;
    protected Item item;
    public ItemView(Item myItem,Sheet sheet){
        this.item=myItem;
        this.sheet=sheet;
        Lam2UI.makeUpContainer(this);
        setPreferredSize(new Dimension(400,200));
    }
}
