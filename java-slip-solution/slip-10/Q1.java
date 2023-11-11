import java.util.Scanner;

interface Cube {
    int cube(int num);
}

public class Q1 implements Cube {
    public int cube(int num) {
        return num * num * num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        Cube c = new Q1();
        int result = c.cube(num);

        System.out.println("Cube of " + num + " is " + result);
        sc.close();
    }
}