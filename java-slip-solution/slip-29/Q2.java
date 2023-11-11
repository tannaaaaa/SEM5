import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vehicle {
    String company;
    double price;

    public void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Company and price of the Vehicle: ");
        company = sc.nextLine();
        price = sc.nextDouble();
    }

    public void display() {
        System.out.println("Company: " + company + " Price: " + price);
    }
}

class LightMotorVehicle extends Vehicle {
    double mileage;

    public void accept() {
        super.accept();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the mileage of the vehicle: ");
        mileage = sc.nextDouble();
    }

    public void display() {
        super.display();
        System.out.println("Mileage: " + mileage);
    }
}

class HeavyMotorVehicle extends Vehicle {
    double capacity_in_tons;

    public void accept() {
        super.accept();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the capacity of vehicle in tons: ");
        capacity_in_tons = sc.nextDouble();
    }

    public void display() {
        super.display();
        System.out.println("Capacity in tons: " + capacity_in_tons);
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vehicles: ");
        int n = sc.nextInt();

        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the type of vehicle (L for LightMotorVehicle, H for HeavyMotorVehicle): ");
            String type = sc.next();
            if (type.equals("L")) {
                LightMotorVehicle vehicle = new LightMotorVehicle();
                vehicle.accept();
                vehicles.add(vehicle);
            } else if (type.equals("H")) {
                HeavyMotorVehicle vehicle = new HeavyMotorVehicle();
                vehicle.accept();
                vehicles.add(vehicle);
            } else {
                System.out.println("Invalid vehicle type. Skipping...");
            }
        }

        System.out.println("Vehicle details:");
        for (Vehicle vehicle : vehicles) {
            vehicle.display();
        }
    }
}