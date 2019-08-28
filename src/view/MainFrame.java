package view;

import app.Sheet;
import tool.Lam2Constants;
import tool.Lam2UI;
import view.menubarview.MenuBarView;
import view.sheetview.SheetContentsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 展示用のメインフレーム。文化祭時にはこのクラスが生成するフレームを常駐させること。
 * @author Miyaoka
 */
public class MainFrame extends JFrame implements WindowListener, KeyListener {
    private JPanel vSheetContents;
    private JPanel vMenuBar;
    private Sheet sheet;

    /**
     * メインフレームを生成する。
     * @param version 現在のLam2バージョン
     * @param firstSheet アプリケーション内で用いるシート
     */
    public MainFrame(String version, Sheet firstSheet) {
        super("Lam2 "+version);
        this.sheet=firstSheet;

        setLayout(new BorderLayout());
        addWindowListener(this);
        setFocusable(true);
        addKeyListener(this);
        setPreferredSize(Lam2Constants.wndSize);
        Lam2Constants.cntSize=getRootPane().getSize();

        vSheetContents = new SheetContentsView(firstSheet);
        add(vSheetContents,BorderLayout.CENTER);

        vMenuBar =new MenuBarView(firstSheet);
        add(vMenuBar,BorderLayout.NORTH);

        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        pack();
        setVisible(true);
    }


    @Override
    public void windowClosing(WindowEvent e) {
        //本当に終了していいのか
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_ESCAPE) {
            sheet.loadModels();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
