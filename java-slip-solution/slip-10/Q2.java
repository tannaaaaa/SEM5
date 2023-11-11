import student.*;
import java.util.Scanner;

public class Q2 {
    public static double StudentPer(int[] marks) {
        double total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (total / (marks.length * 100)) * 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        int rollno = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.print("Enter Class: ");
        String className = sc.nextLine();

        int[] marks = new int[6];
        for (int i = 0; i < 6; i++) {
            System.out.print("Enter Marks for Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        double percentage = StudentPer(marks);

        StudentInfo student = new StudentInfo(rollno, className, percentage);
        System.out.println("\nStudent Information:");
        student.displayStudentInfo();
    }
}
