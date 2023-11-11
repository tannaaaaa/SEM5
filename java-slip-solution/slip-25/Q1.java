import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Student {
    int rollno;
    String name;
    String cls;
    float per;

    void readInfo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter roll number: ");
        rollno = Integer.parseInt(br.readLine());
        System.out.print("Enter student name: ");
        name = br.readLine();
        System.out.print("Enter class: ");
        cls = br.readLine();
        System.out.print("Enter percentage: ");
        per = Float.parseFloat(br.readLine());
    }

    void displayInfo() {
        System.out.println("Student Information");
        System.out.println("Roll Number: " + rollno);
        System.out.println("Name: " + name);
        System.out.println("Class: " + cls);
        System.out.println("Percentage: " + per);
    }
}

public class Q1 {
    public static void main(String[] args) throws IOException {
        Student s = new Student();
        s.readInfo();
        s.displayInfo();
    }
}