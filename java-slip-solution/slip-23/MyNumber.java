
public class MyNumber {
    private int number;
    public MyNumber() {
        this.number = 0;
    }
    public MyNumber(int number) {
        this.number = number;
    }
    public boolean isNegative() {
        return number < 0;
    }
    public boolean isPositive() {
        return number > 0;
    }
    public boolean isZero() {
        return number == 0;
    }
    public boolean isOdd() {
        return number % 2 != 0;
    }
    public boolean isEven() {
        return number % 2 == 0;
    }
    public static void main(String[] args) {
        int value = Integer.parseInt(args[0]);
        MyNumber num = new MyNumber(value);
        System.out.println("The number is " + num.number);
        System.out.println("Is the number negative? " + num.isNegative());
        System.out.println("Is the number positive? " + num.isPositive());
        System.out.println("Is the number zero? " + num.isZero());
        System.out.println("Is the number odd? " + num.isOdd());
        System.out.println("Is the number even? " + num.isEven());
    }
}
