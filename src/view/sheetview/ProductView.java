package view.sheetview;

import itemsmodel.Item;
import itemsmodel.Product;
import itemsmodel.ProductAttr;
import tool.Lam2UI;

import javax.swing.*;
import java.awt.*;

public class ProductView extends ItemView {
    public ProductView(Product myItem) {
        super(myItem);

        ImageIcon imageHandle= (ImageIcon) myItem.getAttr(ProductAttr.Image.toString());
        String titleText= (String) myItem.getAttr(ProductAttr.Title.toString());
        String productorText= (String) myItem.getAttr(ProductAttr.Productor.toString());
        String detailText= (String) myItem.getAttr(ProductAttr.Detail.toString());

        JLabel image=new JLabel(imageHandle);
        add(image, BorderLayout.WEST);

        JLabel title= Lam2UI.getLargeLabel();
        title.setText(titleText);
        add(title,BorderLayout.NORTH);

        JLabel detail= Lam2UI.getNormalLabel();
        detail.setText(detailText);
        add(detail,BorderLayout.CENTER);
    }
}
