public class Q1 {
    public static void main(String[] args) {
        int[][] arr = { {10, 20, 30}, {40, 50, 60} };
        System.out.println("Original Array:");
        printArray(arr);
        System.out.println("After changing the Array:");
        int[][] transposedArr = transpose(arr);
        printArray(transposedArr);
    }

    private static int[][] transpose(int[][] arr) {
        int[][] transposedArr = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                transposedArr[j][i] = arr[i][j];
            }
        }
        return transposedArr;
    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}