class Account {
    String custname;
    int accno;

    public Account() {
        custname = "";
        accno = 0;
    }

    public Account(String name, int acc) {
        custname = name;
        accno = acc;
    }

    public void display() {
        System.out.println("Customer Name: " + custname);
        System.out.println("Account Number: " + accno);
    }
}

class SavingAccount extends Account {
    double savingbal;
    double minbal;

    public SavingAccount() {
        super();
        savingbal = 0.0;
        minbal = 0.0;
    }

    public SavingAccount(String name, int acc, double bal, double min) {
        super(name, acc);
        savingbal = bal;
        minbal = min;
    }

    public void display() {
        super.display();
        System.out.println("Saving Balance: " + savingbal);
        System.out.println("Minimum Balance: " + minbal);
    }
}

class AccountDetail extends SavingAccount {
    double depositamt;
    double withdrawalamt;

    public AccountDetail() {
        super();
        depositamt = 0.0;
        withdrawalamt = 0.0;
    }

    public AccountDetail(String name, int acc, double bal, double min, double dep, double with) {
        super(name, acc, bal, min);
        depositamt = dep;
        withdrawalamt = with;
    }

    public void display() {
        super.display();
        System.out.println("Deposit Amount: " + depositamt);
        System.out.println("Withdrawal Amount: " + withdrawalamt);
    }
}

public class Q2 {
    public static void main(String[] args) {
        AccountDetail acc = new AccountDetail("Austin Makasare", 123456, 5000.0, 1000.0, 2000.0, 1000.0);
        acc.display();
    }
}