package fileProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileFunctions {

    public static Scanner openFileToRead(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        return new Scanner(file);
    }

    public static PrintWriter openFileToWrite(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        return new PrintWriter(file);
    }

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
