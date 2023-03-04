package fileProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileFunctions {

    public Scanner openFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);

        return new Scanner(file);
    }
}
