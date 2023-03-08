package fileProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class for functions for working with files
 */
public class FileFunctions {

    /**
     * Opens the file for reading
     *
     * @param filePath the path to the file to read
     * @return Scanner for further reading of data from the file
     * @throws FileNotFoundException if no such file exists
     */
    public static Scanner openToRead(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        return new Scanner(file);
    }

    /**
     * Opens the file for writing
     *
     * @param filePath the path to the file to write
     * @return PrintWriter for further writing data to a file
     * @throws FileNotFoundException If such a file does not exist and a new one cannot be created
     */
    public static PrintWriter openToWrite(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        return new PrintWriter(file);
    }

    /**
     * Counts the number of large and small letters
     *
     * @param fileScanner Scanner for reading from a file
     * @return an array in which [0] -> amount of small symbols
     *                           [1] -> amount of large symbols
     */
    public static int[] calculateSymbols(Scanner fileScanner) {
        int largeSymbolsAmount = 0;
        int smallSymbolsAmount = 0;

        while (fileScanner.hasNextLine()) {
            String buffer = fileScanner.nextLine();

            for(int i = 0; i < buffer.length(); ++i) {
                if ((int) buffer.charAt(i) >= (int) 'A' && (int) buffer.charAt(i) <= (int) 'Z') {
                    largeSymbolsAmount += 1;
                }

                if ((int) buffer.charAt(i) >= (int) 'a' && (int) buffer.charAt(i) <= (int) 'z') {
                    smallSymbolsAmount += 1;
                }
            }
        }

        return new int[]{smallSymbolsAmount, largeSymbolsAmount};
    }
}
