import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileTools {
    static Logger logger = Logger.getLogger("TcoGeneratorLog");

    /**
     * Method for parsing file extension
     * @param file - file for scanning
     * **/
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }


    /**
     * Method for checking whether a file is a .md file
     * @param file - file for scanning
     * **/
    public static void isMarkDownFile(File file) {
        if (!getFileExtension(file).equals("md")) {
            logger.log(Level.WARNING, "Your file is not Markdown file.");
            System.exit(1);
        }

    }

    /**
     * Method for checking whether a file exists
     * @param file - file for scanning
     * @exception - FileNotFound
     * **/
    public static void isFileExist(File file) {
        if (!file.exists()) {

            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                logger.log(Level.WARNING, "No such file.");
                System.exit(1);
            }
        }
    }
}