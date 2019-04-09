package itemsmodel;

import tool.Lam2Tool;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Product extends Item {
    @Override
    public ItemKind getKind() {
        return ItemKind.PRODUCT;
    }

    @Override
    public String toString() {
        return (String) this.getAttr(ProductAttr.Title.toString());
    }

    public Product(File directory) {
        super(directory);

        String title = this.myDirectory.getName();
        title = title.replaceAll("^.", "");
        this.attrs.put(ProductAttr.Title.toString(), title);

        for (File f : this.myDirectory.listFiles()) {
            if (f.getName().matches("^image\\..*$")) {
                ImageIcon image = new ImageIcon(f.toString());
                this.attrs.put(ProductAttr.Image.toString(), image);
            }
            if (f.getName().equals("detail.txt")) {
                this.attrs.put(ProductAttr.Detail.toString(),
                        Lam2Tool.readTextAll(f.toString()));
            }
            if (f.getName().equals("productor.txt")) {
                this.attrs.put(ProductAttr.Productor.toString(),
                        Lam2Tool.readTextAll(f.toString()));
            }
            if (f.getName().matches("^entrypt\\..*$")) {
                this.attrs.put(ProductAttr.Entrypt.toString(), f.toString());
            }
        }
    }

    public void execute() {
        String[] command = new String[]{
                "cmd",
                "/c",
                (String) getAttr(ProductAttr.Entrypt.toString())
        };
        try {
            Runtime.getRuntime().exec(command, null, this.myDirectory);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
