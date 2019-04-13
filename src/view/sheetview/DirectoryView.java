package view.sheetview;

import itemsmodel.Directory;
import itemsmodel.DirectoryAttr;
import itemsmodel.Item;
import tool.Lam2UI;

import javax.lang.model.element.ModuleElement;
import javax.swing.*;
import java.awt.*;

public class DirectoryView extends ItemView {
    public DirectoryView(Directory myItem) {
        super(myItem);
        setPreferredSize(new Dimension(500, 100));

        GridBagLayout l=new GridBagLayout();
        setLayout(l);
        GridBagConstraints g=new GridBagConstraints();

        ImageIcon imageHandle = (ImageIcon) myItem.getAttr(DirectoryAttr.Image.toString());
        String titleText = (String) myItem.getAttr(DirectoryAttr.Title.toString());
        String detailText = (String) myItem.getAttr(DirectoryAttr.Detail.toString());

        JLabel image=new JLabel(imageHandle);
        image.setPreferredSize(new Dimension(100,100));
        g.gridx=0;g.gridy=0;g.gridheight=3;
        l.setConstraints(image,g);

        JLabel title=Lam2UI.getLargeLabel();
        title.setText(titleText);
        System.out.println(title.getText());
        g.gridx=1;g.gridy=0;g.gridheight=1;
        l.setConstraints(title,g);

        JLabel detail= Lam2UI.getNormalLabel();
        detail.setText(detailText);
        g.gridx=1;g.gridy=1;g.gridheight=2;
        l.setConstraints(detail,g);

        add(image);
        add(title);
        add(detail);
    }
}
