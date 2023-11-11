import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of cities: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] cities = new String[n];
        System.out.println("Enter cities names:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name :" + (i+1) +": ");            
            cities[i] = sc.nextLine();
        }
        Arrays.sort(cities);
        System.out.println("Sorted Cities:");
        for (int i = 0; i < n; i++) {
            System.out.println(cities[i]);
        }
        sc.close();
    }
}