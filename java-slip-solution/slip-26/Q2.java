import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Donor implements Serializable {
    String name, address, group;
    int age, lod;
    Long contact;

    public Donor(String name, String address, String group, int age, Long contact, int lod) {
        this.name = name;
        this.address = address;
        this.group = group;
        this.age = age;
        this.contact = contact;
        this.lod = lod;
    }

    @Override
    public String toString() {
        return "\nName: " + name + ", Age: " + age + ", Address: " + address + ", Group: " + group + ", Contact: " + contact + ", Last Donation: " + lod;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter how many records you want: ");
        int n = s.nextInt();
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("save.txt"));
            Donor d[] = new Donor[n];
            for (int i = 0; i < n; i++) {
                System.out.print("\nName: ");
                String name = s.next();
                System.out.print("Age: ");
                int age = s.nextInt();
                System.out.print("Address: ");
                String address = s.next();
                System.out.print("Contact: ");
                Long contact = s.nextLong();  // Changed to int
                System.out.print("Group: ");
                String group = s.next();
                System.out.print("Last donation: ");
                int lod = s.nextInt();
                d[i] = new Donor(name, address, group, age, contact, lod);  // Initialize Donor object
                o.writeObject(d[i]);
            }
            o.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            ObjectInputStream z = new ObjectInputStream(new FileInputStream("save.txt"));
            for (int i = 0; i < n; i++) {
                Donor donor = (Donor) z.readObject();
                if (donor.group.equals("A+ve") && donor.lod >= 6)
                    System.out.println(donor);
            }
            z.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
