import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of row: ");
        int n = s.nextInt();
        System.out.println("Enter the size of column: ");
        int m = s.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.println("Enter element at "+ i + " row "+ j + " column");
                arr[i][j] = s.nextInt();
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
