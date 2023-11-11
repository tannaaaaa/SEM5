class ZeroException extends Exception {
    public ZeroException(String message) {
        super(message);
    }
}

public class Q1 {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt(args[0]);
            if (num == 0) {
                throw new ZeroException("Number is 0");
            } else {
                boolean isPrime = true;
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.println(num + " is a prime number.");
                } else {
                    System.out.println(num + " is not a prime number.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (ZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}