import SY.*;
import TY.*;
import java.util.*;

public class Q2 {
    int rollNumber;
    String name;
    SYMarks sy;
    TYMarks ty;

    public Q2(int r, String n, SYMarks s, TYMarks t) {
        rollNumber = r;
        name = n;
        sy = s;
        ty = t;
    }

    public int getComputerMarks() {
        return sy.ComputerTotal + ty.Theory;
    }

    public String getGrade() {
        int marks = getComputerMarks();
        if (marks >= 70) {
            return "A";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else if (marks >= 40) {
            return "Pass Class";
        } else {
            return "FAIL";
        }
    }

    public void display() {
        System.out.println("\nRoll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Computer Marks: " + getComputerMarks());
        System.out.println("Grade: " + getGrade());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        Q2[] students = new Q2[n];
        for (int i = 0; i < n; i++) 
        {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            System.out.print("Roll Number: ");
            int rollNumber = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Enter SY Marks (ComputerTotal, MathsTotal, ElectronicsTotal): ");
            int c = sc.nextInt();
            int m = sc.nextInt();
            int e = sc.nextInt();
            SYMarks sy = new SYMarks(c, m, e);

            System.out.print("Enter TY Marks (Theory, Practicals): ");
            int t = sc.nextInt();
            int p = sc.nextInt();
            TYMarks ty = new TYMarks(t, p);
            students[i] = new Q2(rollNumber, name, sy, ty);
        }
        for (int i = 0; i < n; i++) {
            students[i].display();
        }
    }
}
