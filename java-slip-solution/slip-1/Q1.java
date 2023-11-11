public class Q1 {
    public static void main(String[] args) {
        int n = args.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        for (int i = 0; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && arr[i] > 1) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}