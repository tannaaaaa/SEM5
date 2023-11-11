import java.io.File;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No command line arguments found.");
            return;
        }

        String path = args[0];
        File file = new File(path);

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            int count = 0;

            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    System.out.println("Do you want to delete " + f.getName() + "? (y/n)");
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();

                    if (input.equalsIgnoreCase("y")) {
                        if (f.delete()) {
                            count++;
                            System.out.println(f.getName() + " deleted successfully.");
                        } else {
                            System.out.println("Failed to delete " + f.getName() + ".");
                        }
                    }
                }
            }

            System.out.println(count + " files deleted from the directory.");
        } else if (file.isFile()) {
            System.out.println("File name: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("Last modified: " + file.lastModified());
        } else {
            System.out.println("Invalid path.");
        }
    }
}