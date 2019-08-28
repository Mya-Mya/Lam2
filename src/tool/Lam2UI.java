package tool;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Lam2UI {
    public static final Font mainFont=new Font("メイリオ",Font.PLAIN,15);
    public static final Font boldFont=new Font("メイリオ",Font.BOLD,20);
    public static final Color ume=new Color(234,173,189);
    public static final Color alphaUme=new Color(234, 16, 0, 50);
    public static final Color sumire=new Color(85,69,98);
    public static final Color alphaSumire=new Color(72, 4,98, 50);
    public static final Color sakura=new Color(250,219,224);
    public static final Color alphaAakura=new Color(250, 7, 0, 50);
    public static final Color black=new Color(32, 32, 32);
    public static final Color gray1=new Color(62, 62, 62);
    public static final Color gray2=new Color(112, 112, 112);
    public static final Color white=new Color(251, 251, 251);

    private static final JLabel getLabel(){
        JLabel out=new JLabel();
        out.setBackground(black);
        out.setForeground(white);
        out.setFont(mainFont);
        out.setBorder(null);
        return out;
    }
    public static final JLabel getNormalLabel(){
        JLabel out=getLabel();
        out.setFont(mainFont);
        return out;
    }
    public static final JLabel getLargeLabel(){
        JLabel out=getLabel();
        out.setFont(boldFont);
        return out;
    }

    public static final JButton getButton(){
        JButton out=new JButton();
        out.setBackground(gray1);
        out.setForeground(white);
        out.setFont(mainFont);
        out.setBorderPainted(false);
        out.setContentAreaFilled(false);
        return out;
    }

    public static final void makeUpContainer(JComponent you){
        you.setBackground(black);
        you.setForeground(white);
        you.setBorder(null);
    }

}
