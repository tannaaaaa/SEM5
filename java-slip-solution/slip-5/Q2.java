import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no,of rows of matrix 1: ");
        int r1 = sc.nextInt();
        System.out.print("Enter the no.of columns of matrix 1: ");
        int c1 = sc.nextInt();
        int[][] matrix1 = new int[r1][c1];
        System.out.println("Enter the elements of matrix 1:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the no.of rows of matrix 2: ");
        int r2 = sc.nextInt();
        System.out.print("Enter the no.of columns of matrix 2: ");
        int c2 = sc.nextInt();
        int[][] matrix2 = new int[r2][c2];
        System.out.println("Enter the elements of matrix 2:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Matrix Addition");
            System.out.println("2. Matrix Multiplication");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (r1 != r2 || c1 != c2) {
                        System.out.println("Matrices cannot be added.");
                        break;
                    }
                    int[][] sum = new int[r1][c1];
                    for (int i = 0; i < r1; i++) {
                        for (int j = 0; j < c1; j++) {
                            sum[i][j] = matrix1[i][j] + matrix2[i][j];
                        }
                    }
                    System.out.println("Sum of matrices:");
                    printMatrix(sum);
                    break;
                case 2:
                    if (c1 != r2) {
                        System.out.println("Matrices cannot be multiplied.");
                        break;
                    }
                    int[][] product = new int[r1][c2];
                    for (int i = 0; i < r1; i++) {
                        for (int j = 0; j < c2; j++) {
                            for (int k = 0; k < c1; k++) {
                                product[i][j] += matrix1[i][k] * matrix2[k][j];
                            }
                        }
                    }
                    System.out.println("Product of matrices:");
                    printMatrix(product);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
        sc.close();
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}