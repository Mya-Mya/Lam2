package view.menubarview;

import app.Sheet;

import javax.swing.*;

public class MenuBarView extends JPanel {
    public MenuBarView(Sheet sheet) {
        add(new BreadcrumbsView(sheet));
        add(new TitleView(sheet));
    }
}
