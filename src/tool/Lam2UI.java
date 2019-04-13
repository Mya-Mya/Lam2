package tool;

import javax.swing.*;

public class Lam2UI {
    public static final JLabel getNormalLabel(){
        JLabel out=new JLabel();
        out.setFont(Lam2Constants.mainFont);
        return out;
    }
    public static final JLabel getLargeLabel(){
        JLabel out=getNormalLabel();
        out.setFont(Lam2Constants.boldFont);
        return out;
    }
}
