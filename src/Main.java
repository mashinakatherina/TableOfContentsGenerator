import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please put path to your *.md file here: ");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        in.close();
        File file = new File(path);
        System.out.println("Your file is: " + file.getName());
        FileTools.isFileExist(file);
        FileTools.isMarkDownFile(file);
        System.out.println("=================");

        System.out.println(TcoGenerator.generateTco(file));
        for (int i = 0; i < TcoGenerator.readFile(file).size(); i++) {
            System.out.println(TcoGenerator.readFile(file).get(i));
        }

    }
}
