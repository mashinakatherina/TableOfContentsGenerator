import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static java.lang.Math.max;

public class TcoGenerator {

    /**
     * Method for reading file
     * @param file - file for scanning
     * @return - file content as List
     * **/

    public static List readFile(File file) {

        List<String> lines = null;

        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return lines;
    }

    /**
     * Method for calculating the maximum nesting of headers in a file
     * @param file - file for scanning
     * @return - maximum nesting
     * **/

    public static int countMaxDepth(File file) {
        List<String> lines;
        lines = readFile(file);

        int levelIndex = 0;
        int maxLevelIndex = -1;
        for (String inputString : lines) {
            char[] chars = inputString.toCharArray();
            for (char aChar : chars) {
                if (aChar == '#') {
                    levelIndex++;
                    maxLevelIndex = max(maxLevelIndex, levelIndex);
                }
            }
        }
        return maxLevelIndex;
    }

    /**
     * Method for preparing table of contents
     * @param file - file for scanning
     * @return - table of contents with tabs
     * **/

    public static String generateTco(File file) {

        List<String> lines;
        lines = readFile(file);

        int[] indexes = new int[countMaxDepth(file)];
        StringBuilder result = new StringBuilder();

        for (String inputString : lines) {
            char[] chars = inputString.toCharArray();
            int levelIndex = 0;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j - 1] == '#') {
                    levelIndex++;
                }
                if (chars[j] == '#' && chars[j - 1] == '#') {
                    result.append("\t");
                }
            }
            indexes[levelIndex]++;
            if (chars[0] == '#') {
                result.append(indexes[levelIndex]).append(". [")
                        .append(inputString.replaceAll("#", "").trim())
                        .append("]").append("(#").append(inputString.replaceAll("#", "")
                        .toLowerCase().trim().replaceAll(" ", "-")).append(")\n");
            }
        }
        return result.toString();
    }

}
