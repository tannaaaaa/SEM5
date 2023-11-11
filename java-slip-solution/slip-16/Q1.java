import java.util.Scanner;

interface Square { 
    int calculate(int x); 
   } 
public class Q1 { 
        public static void main(String args[]) { 
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Number: ");
            int a = sc.nextInt();
            Square s = (int x) -> x * x; 
            int ans = s.calculate(a); 
            System.out.println("Square = "+ans); 
            sc.close();
        } 
   }