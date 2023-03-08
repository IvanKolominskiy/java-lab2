import fileProcessing.FileFunctions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input the path to the file to read");
        String fileToReadPath = in.nextLine();
        System.out.println("Input the path to the file to write");
        String fileToWritePath = in.nextLine();

        try(Scanner sc = FileFunctions.openFileToRead(fileToReadPath);
            PrintWriter pw = FileFunctions.openFileToWrite(fileToWritePath)) {
            int[] result = FileFunctions.calculateSymbols(sc);

            pw.println("Amount of small letters: " + result[0] + "\nAmount of large letters: " + result[1]);
        } catch (FileNotFoundException e) {
            System.out.println("File for reading not found!");
        }
    }
}