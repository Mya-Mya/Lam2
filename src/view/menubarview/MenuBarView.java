package view.menubarview;

import app.Sheet;
import tool.Lam2UI;

import javax.swing.*;
import java.awt.*;

public class MenuBarView extends JPanel {
    public MenuBarView(Sheet sheet) {
        super();
        setLayout(new BorderLayout());
        add(new TitleView(sheet),BorderLayout.CENTER);
        add(new BreadcrumbsView(sheet),BorderLayout.SOUTH);
        Lam2UI.makeUpContainer(this);
    }
}
