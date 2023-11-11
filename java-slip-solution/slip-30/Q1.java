import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    String Personname;
    String Aadharno;
    String Panno;

    public Person(String Personname, String Aadharno, String Panno) {
        this.Personname = Personname;
        this.Aadharno = Aadharno;
        this.Panno = Panno;
    }

    public void display() {
        System.out.println("\nPerson Name: " + Personname);
        System.out.println("Aadhar Number: " + Aadharno);
        System.out.println("PAN Number: " + Panno);
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("\nEnter details for person " + (i+1) + ":");
            System.out.print("Person Name:");
            String Personname = sc.nextLine();
            System.out.print("Aadhar Number:");
            String Aadharno = sc.nextLine();
            System.out.print("PAN Number:");
            String Panno = sc.nextLine();
            Person person = new Person(Personname, Aadharno, Panno);
            persons.add(person);
        }

        System.out.println("Person details:");
        for (Person person : persons) {
            person.display();
        }
    }
}