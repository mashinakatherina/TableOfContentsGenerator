import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        in.close();
        File file = new File(path);
        FileTools.isFileExist(file);
        FileTools.isMarkDownFile(file);

        System.out.println(TcoGenerator.generateTco(file));
        for (int i = 0; i < TcoGenerator.readFile(file).size(); i++) {
            System.out.println(TcoGenerator.readFile(file).get(i));
        }

    }
}
