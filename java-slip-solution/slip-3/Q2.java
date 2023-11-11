import java.util.Scanner;

class CovidException extends Exception {
    public CovidException(String message) {
        super(message);
    }
}

class Patient {
    String name;
    int age,oxy_level,HRCT_report;

    public Patient(String name, int age, int oxy, int HRCT) {
        this.name = name;
        this.age = age;
        this.oxy_level = oxy;
        this.HRCT_report = HRCT;
    }

    public void display() {
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Age: "+ age);
        System.out.println("Patient Oxygen Level: " + oxy_level);
        System.out.println("Patient HRCT Report: " + HRCT_report);
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Patient Oxygen Level: ");
        int oxy = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Patient HRCT Report: ");
        int HRCT = sc.nextInt();

        try {
            if (oxy < 95 || HRCT > 10) {
                throw new CovidException("Patient is Covid Positive(+) and Need to Hospitalized");
            } else {
                Patient p = new Patient(name, age, oxy, HRCT);
                p.display();
            }
        } catch (CovidException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}