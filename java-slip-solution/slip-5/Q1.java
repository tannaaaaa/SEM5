import java.util.Scanner;

class Continent {
    String continentName;

    Continent(String name) {
        this.continentName = name;
    }
}

class Country extends Continent {
    String countryName;

    Country(String continentName, String name) {
        super(continentName);
        this.countryName = name;
    }
}

class State extends Country {
    String stateName;

    State(String continentName, String countryName, String name) {
        super(continentName, countryName);
        this.stateName = name;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Continent: ");
        String continentName = sc.nextLine();

        System.out.print("Enter Country: ");
        String countryName = sc.nextLine();

        System.out.print("Enter State: ");
        String stateName = sc.nextLine();

        State state = new State(continentName, countryName, stateName);

        System.out.println("State: " + state.stateName);
        System.out.println("Country: " + state.countryName);
        System.out.println("Continent: " + state.continentName);

        // Close the scanner to release resources
        sc.close();
    }
}
