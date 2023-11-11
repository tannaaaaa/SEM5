class Employee {
    private int empId;
    private String empName;
    private String empDesignation;
    private double empSal;

    public Employee(int empId, String empName, String empDesignation, double empSal) {
        this.empId = empId;
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.empSal = empSal;
    }

    public String toString() {
        return "Employee ID: " + empId + "\nEmployee Name: " + empName + "\nEmployee Designation: " + empDesignation + "\nEmployee Salary: " + empSal;
    }

}

public class Q1 {
    public static void main(String[] args) {
        Employee emp = new Employee(101,"Austin","Manager",50000);
        System.out.println(emp.toString());
    }
}