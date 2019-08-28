package view.sheetview;

import app.Sheet;
import itemsmodel.Item;
import itemsmodel.Product;
import itemsmodel.ProductAttr;
import tool.Lam2UI;

import javax.swing.*;
import java.awt.*;

public class ProductView extends ItemView {
    public ProductView(Product myItem, Sheet sheet) {
        super(myItem,sheet);

        ImageIcon lImageData= (ImageIcon) myItem.getAttr(ProductAttr.Image.toString());
        String lTitleData= (String) myItem.getAttr(ProductAttr.Title.toString());
        String lProducterData= (String) myItem.getAttr(ProductAttr.Productor.toString());
        String lDetailData= (String) myItem.getAttr(ProductAttr.Detail.toString());

        JLabel lImage=new JLabel(lImageData);

        JLabel lTitle= Lam2UI.getLargeLabel();
        lTitle.setText(lTitleData);

        JLabel lDetail= Lam2UI.getNormalLabel();
        lDetail.setText(lDetailData);

        add(lImage, BorderLayout.WEST);
        add(lTitle,BorderLayout.NORTH);
        add(lDetail,BorderLayout.CENTER);
    }
}
