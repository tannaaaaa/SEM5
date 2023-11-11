import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter a file name.");
            return;
        }
        String fileName = args[0];
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            int lines = 0;
            int words = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines++;
                String[] wordsArray = line.split("\\s+");
                words += wordsArray.length;
            }
            System.out.println("Number of words: " + words);
            System.out.println("Number of lines: " + lines);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}