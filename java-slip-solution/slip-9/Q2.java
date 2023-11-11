import java.util.Scanner;

interface Marker {}

class Product implements Marker {
    int P_id, P_cost, P_quantity;
    String P_name;
    static int count = 0;

    public Product() {
        count++;
    }

    public Product(int id, String name, int cost, int quantity) {
        P_id = id;
        P_name = name;
        P_cost = cost;
        P_quantity = quantity;
        count++;
    }

    public void display() {
        System.out.println("\nProduct ID: " + P_id);
        System.out.println("Product Name: " + P_name);
        System.out.println("Product Cost: " + P_cost);
        System.out.println("Product Quantity: " + P_quantity);
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[6];

        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for Product " + (i+1) + ":");
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Product Cost: ");
            int cost = sc.nextInt();
            System.out.print("Enter Product Quantity: ");
            int quantity = sc.nextInt();
            products[i] = new Product(id, name, cost, quantity);
        }

        for (int i = 3; i < 6; i++) {
            products[i] = new Product();
        }

        System.out.println("Details of Products:");
        for (int i = 0; i < 3; i++) {
            products[i].display();
        }

        System.out.println("Object Count: " + Product.count);

        sc.close();
    }
}