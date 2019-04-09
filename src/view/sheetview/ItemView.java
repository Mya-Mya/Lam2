package view.sheetview;

import itemsmodel.Item;

import javax.swing.*;
import java.awt.*;

public abstract class ItemView extends JPanel {
    public ItemView(Item myItem){
        setPreferredSize(new Dimension(400,200));
        setBackground(Color.GREEN);
    }
}
