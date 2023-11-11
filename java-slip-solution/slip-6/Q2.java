import java.util.Scanner;

abstract class Order {
    int id;
    String description;

    public Order(int id, String description) {
        this.id = id;
        this.description = description;
    }

    abstract void accept();
    abstract void display();
}

class PurchaseOrder extends Order {
    String customerName;

    public PurchaseOrder(int id, String description, String customerName) {
        super(id, description);
        this.customerName = customerName;
    }

    void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        customerName = sc.nextLine();
        sc.close();
    }

    void display() {
        System.out.println("Purchase Order:");
        System.out.println("ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Customer Name: " + customerName);
    }
}

class SalesOrder extends Order {
    String vendorName;

    public SalesOrder(int id, String description, String vendorName) {
        super(id, description);
        this.vendorName = vendorName;
    }

    void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vendor name: ");
        vendorName = sc.nextLine();
        sc.close();
    }

    void display() {
        System.out.println("Sales Order:");
        System.out.println("ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Vendor Name: " + vendorName);
    }
}

public class Q2 {
    public static void main(String[] args) {
        PurchaseOrder[] po = new PurchaseOrder[3];
        SalesOrder[] so = new SalesOrder[3];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for Purchase Order " + (i+1) + ":");
            System.out.print("\nEnter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Description: ");
            String description = sc.nextLine();
            po[i] = new PurchaseOrder(id, description,"");
            po[i].accept();
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for Sales Order " + (i+1) + ":");
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Description: ");
            String description = sc.nextLine();
            so[i] = new SalesOrder(id, description, "");
            so[i].accept();
        }

        System.out.println("\nDetails of Purchase Orders:");
        for (int i = 0; i < 3; i++) {
            po[i].display();
        }

        System.out.println("\nDetails of Sales Orders:");
        for (int i = 0; i < 3; i++) {
            so[i].display();
        }
        sc.close();
    }
}