import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the source file: ");
        String File1 = sc.nextLine();

        System.out.print("Enter the name of the target file: ");
        String File2 = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(File1));
             PrintWriter writer = new PrintWriter(new FileWriter(File2))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }

            System.out.println("Contents copied from " + File1 + " to " + File2);
        } catch (IOException e) {
            System.err.println("An error occurred while copying the contents: " + e.getMessage());
        }
    }
}
