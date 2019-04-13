import app.Sheet;
import app.Sheet4Debug;
import itemsmodel.Directory;
import itemsmodel.Item;
import itemsmodel.Product;
import tool.Lam2Constants;
import tool.Lam2Tool;
import view.MainFrame;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Sheet firstSheet=new Sheet(
                System.getProperty("user.dir")+"/"+ Lam2Constants.ROOT_PATH
        );
        new MainFrame("beta03",firstSheet);
        firstSheet.loadModels();
    }

    /*public void testCode() {
        File rootDirectory = new File(System.getProperty("user.dir") + "/items");
        Directory root = new Directory(rootDirectory, null);
        Sheet firstSheet = new Sheet(root);
        Sheet4Debug sheet = new Sheet4Debug(root);
        while (true) {
            String command = new Scanner(System.in).next();
            if (command.equals("exit")) break;
            if (command.equals("a")) sheet.showAttrs();
            if (command.equals("c")) sheet.showChildren();
            if (command.equals("h")) sheet.showHierarchy();
            if (command.equals("u")) sheet.goUp();
            if (command.equals("r")) {
                System.out.println("indx?");
                List<Item> l = sheet.getChildList();
                ((Product) l.get(new Scanner(System.in).nextInt())).execute();
            }
            if (command.equals("i")) {
                System.out.println("indx?");
                sheet.goInto(new Scanner(System.in).nextInt());
            }
        }
    }*/
}
