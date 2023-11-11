import java.util.Scanner;

interface Operation {
    double PI = 3.142;
    double volume();
}

class Cylinder implements Operation {
    double radius, height;

    public Cylinder(double r, double h) {
        radius = r;
        height = h;
    }
    public double volume() {
        return PI * radius * radius * height;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the radius: ");
        double radius = sc.nextDouble();

        System.out.print("Enter the height: ");
        double height = sc.nextDouble();

        Cylinder cylinder = new Cylinder(radius, height);

        System.out.println("Cylinder Volume: " + cylinder.volume());
        sc.close();
    }
}