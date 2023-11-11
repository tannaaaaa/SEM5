package student;

public class StudentInfo {
    private int rollno;
    private String className;
    private double percentage;

    public StudentInfo(int rollno, String className, double percentage) {
        this.rollno = rollno;
        this.className = className;
        this.percentage = percentage;
    }

    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollno);
        System.out.println("Class: " + className);
        System.out.println("Percentage: " + percentage + "%");
    }
}
