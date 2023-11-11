import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String deptName;
    private double salary;
    private static int objectCount = 0;

    public Employee() {
        objectCount++;
    }

    public Employee(int id, String name, String deptName, double salary) {
        this(); // Calls the default constructor to increment objectCount
        this.id = id;
        this.name = name;
        this.deptName = deptName;
        this.salary = salary;
        System.out.println("\n Object created. Total objects: " + objectCount);
    }

    public void display() {
        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department Name: " + deptName);
        System.out.println("Salary: " + salary);
    }

    public static int getObjectCount() {
        return objectCount;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter no.of Employee:");
        int n = scanner.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for employee " + (i + 1));
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Department Name: ");
            String deptName = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            employees[i] = new Employee(id, name, deptName, salary);
        }

        System.out.println("Employee objects created:");
        for (Employee employee : employees) {
            employee.display();
        }
        System.out.println("Total Employee Objects: " + Employee.getObjectCount());

        scanner.close();
    }
}
