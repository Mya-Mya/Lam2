package tool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lam2Tool {
    /**
     * テキストファイル内のテキストを全て読み込む。
     * @param filePath ファイルの場所（ファイルはUTF-8で書かれていることが必須）
     * @return 読み込んだテキストファイルの内容
     */
    public static final String readTextAll(String filePath) {
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            line = br.readLine();
            while (line != null) {
                sb.append(line + System.getProperty("line.separator"));
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(sb.charAt(0)=='\uFEFF')sb.delete(0,1);
        return sb.toString();
    }
}
