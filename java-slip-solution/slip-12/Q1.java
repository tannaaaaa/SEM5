class College {
    int cno;
    String cname;
    String caddr;

    public College(int cno, String cname, String caddr) {
        this.cno = cno;
        this.cname = cname;
        this.caddr = caddr;
    }

    public void displayCollegeDetails() {
        System.out.println("College Number: " + cno);
        System.out.println("College Name: " + cname);
        System.out.println("College Address: " + caddr);
    }
}

class Department extends College {
    int dno;
    String dname;

    public Department(int cno, String cname, String caddr, int dno, String dname) {
        super(cno, cname, caddr);
        this.dno = dno;
        this.dname = dname;
    }

    public void displayDepartmentDetails() {
        System.out.println("Department Number: " + dno);
        System.out.println("Department Name: " + dname);
    }
}

public class Q1 {
    public static void main(String[] args) {
        Department dept = new Department(1, "KKW College", "Nashik", 101, "Computer Science");
        dept.displayCollegeDetails();
        dept.displayDepartmentDetails();
    }
}