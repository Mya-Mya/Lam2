package tool;

import javax.swing.*;
import java.awt.*;

public class Lam2UI {
    public static final Font mainFont=new Font("メイリオ",Font.PLAIN,13);
    public static final Font boldFont=new Font("メイリオ",Font.BOLD,15);
    public static final Color ume=new Color(234,173,189);
    public static final Color alphaUme=new Color(234, 16, 0, 50);
    public static final Color sumire=new Color(85,69,98);
    public static final Color alphaSumire=new Color(72, 4,98, 50);
    public static final Color sakura=new Color(250,219,224);
    public static final Color alphaAakura=new Color(250, 7, 0, 50);


    public static final JLabel getNormalLabel(){
        JLabel out=new JLabel();
        out.setFont(Lam2UI.mainFont);
        return out;
    }
    public static final JLabel getLargeLabel(){
        JLabel out=getNormalLabel();
        out.setFont(Lam2UI.boldFont);
        return out;
    }


    public static final JButton getButton(){
        JButton out=new JButton();
        out.setFont(Lam2UI.mainFont);
        out.setBorderPainted(false);
        return out;
    }
}
