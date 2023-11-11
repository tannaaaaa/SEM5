import java.util.Scanner;

abstract class Staff {
    protected int id;
    protected String name;

    public Staff(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void displayDetails();
}

class OfficeStaff extends Staff {
    private String department;

    public OfficeStaff(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println();
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Enter the number of Office Staff: ");
        n = sc.nextInt();

        OfficeStaff[] staffList = new OfficeStaff[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Office Staff #" + (i + 1));
            System.out.print("\nID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            staffList[i] = new OfficeStaff(id, name, department);
        }

        System.out.println("Details of Office Staff:");
        for (int i = 0; i < n; i++) {
            staffList[i].displayDetails();
        }
        // Close the scanner to release resources
        sc.close();
    }
}
