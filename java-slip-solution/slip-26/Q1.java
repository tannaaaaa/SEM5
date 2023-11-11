import java.io.IOException;

class Student {
    int item_number;
    String item_name;
    float item_price;
    static int count = 0;

    Student() {
        item_number = 0;
        item_name = "";
        item_price = 0.0f;
        count++;
    }

    Student(int item_number, String item_name, float item_price) {
        this.item_number = item_number;
        this.item_name = item_name;
        this.item_price = item_price;
        count++;
    }

    void display() {
        System.out.println("Item Number: " + item_number);
        System.out.println("Item Name: " + item_name);
        System.out.println("Item Price: " + item_price);
    }

    static void displayCount() {
        System.out.println("Number of objects created: " + count);
    }
}

public class Q1 {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student(1, "Pen", 10.0f);
        s1.display();
        Student.displayCount();

        Student s2 = new Student(2, "Pencil", 5.0f);
        s2.display();
        Student.displayCount();

        Student s3 = new Student(3, "Eraser", 3.0f);
        s3.display();
        Student.displayCount();
    }
}