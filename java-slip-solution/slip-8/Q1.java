import java.util.Scanner;

class Sphere {
    public double getSurfaceArea(double radius) {
        return 4 * Math.PI * radius * radius;
    }

    public double getVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sphere sphere = new Sphere();
        System.out.print("Enter the radius of a sphere: ");
        double radius = sc.nextInt();
        System.out.println("Surface area of sphere = " + sphere.getSurfaceArea(radius));
        System.out.println("Volume of sphere = " + sphere.getVolume(radius));
        sc.close();
    }
}