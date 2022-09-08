import java.util.Scanner;

public class LargestRowColumnSum {

    public static int[][] takeInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows = s.nextInt();
        System.out.println("Enter number of cols");
        int cols = s.nextInt();
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Enter the element at " + i + " row " + j + " column");
                arr[i][j] = s.nextInt();
            }
        }
        return arr;
    }

    public static int largestRowColSum(int[][] arr) {
        boolean isRow = true;
        int rows = arr.length;
        int cols = arr[0].length;
        int largest = Integer.MIN_VALUE;
        int num = 0;
        if (rows == 0) {
            System.out.println("row 0 " + largest);
        }
        for (int k = 0; k < rows; k++) {
            int add = 0;
            for (int l = 0; l < arr[0].length; l++) {
                add += arr[k][l];
            }
            if (add > largest) {
                largest = add;
                num = k;
            }
        }
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum = sum + arr[i][j];
            }
            if (sum > largest) {
                largest = sum;
                num = j;
                isRow = false;
            }
        }

        if (isRow) {
            System.out.print("row " + num + " " + largest);
        } else {
            System.out.print("column " + num + " " + largest);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] array = takeInput();
        int larColRowSum = largestRowColSum(array);
        System.out.println(larColRowSum);
    }
}

