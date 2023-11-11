import java.io.File;
import java.util.Scanner;

public class Q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String filename = "";
        System.out.print("Enter filename: ");
        filename = sc.nextLine();
        
        File f = new File(filename);
        System.out.println("File exists: " + f.exists());
        System.out.println("File is readable: " + f.canRead());
        System.out.println("File is writable: " + f.canWrite());
        System.out.println("Type of file: " + getFileExtension(f));
        System.out.println("Length of file: " + f.length() + " bytes");
        sc.close();
    }

    public static String getFileExtension(File file) {
        String extension = "";
        String fileName = file.getName();
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
}