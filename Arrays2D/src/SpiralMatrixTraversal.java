import java.util.Scanner;

public class SpiralMatrixTraversal {
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
    public static int[][] SpiralMatrix(int[][] arr){
        int top = 0, down = arr.length - 1, left = 0, right = arr.length -1;
        int i;

        while(top <= down && left <= right){
                for (i = left; i <= right; i++) {
                    System.out.print(arr[top][i]);

                }top++;

                for (i = top; i <= down; i++) {
                    System.out.print(arr[i][right]);

                }right--;
            if (top < down){
                for (i = right; i >= left; i--) {
                    System.out.print(arr[down][i]);

                }down--;
            }
            if (left < right) {
                for (i = down; i >= top; i--) {
                    System.out.print(arr[i][left]);

                }left++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[][] array = takeInput();
        int[][] matrix = SpiralMatrix(array);
        System.out.print(matrix + " ");
    }
}
