import java.util.Scanner; 
class Customer { 
    String name; 
    Long Pno; 
} 
class Depositer extends Customer { 
    int accno; 
    double bal; 
} 
class Borrower extends Depositer { 
    int loanno; 
    double loanamt; 
 
    void read() { 
        System.out.println("enter name, Phone number, accno, bal, loanno, loanamt"); 
        Scanner sc = new Scanner(System.in); 
        this.name = sc.next(); 
        this.Pno = sc.nextLong(); 
        this.accno = sc.nextInt(); 
        this.bal = sc.nextDouble(); 
        this.loanno = sc.nextInt(); 
        this.loanamt = sc.nextDouble(); 
    } 
    void display() { 
        System.out.println("The details are:"); 
        System.out.println("name: " +this.name); 
        System.out.println("phone number: "+this.Pno); 
        System.out.println("accout number: " +this.accno);
        System.out.println("Balance: " +this.bal); 
        System.out.println("loan number: "+this.loanno); 
        System.out.println("loan amount: "+this.loanamt);
        System.out.println("------------------------------------"); 
    } 
 
 public static void main(String args[]){ 
    int i; 
    Scanner sc = new Scanner(System.in); 
    System.out.println("enter total number:"); 
    int n =sc.nextInt(); 
    Borrower[] l = new Borrower[n]; 
    for(i=0;i<n;i++){ 
        l[i] = new Borrower(); 
        l[i].read(); 
    } 
    for(i=0;i<n;i++){ 
        l[i].display(); 
    } 
} 
}