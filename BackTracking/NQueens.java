package BackTracking;

import java.util.Scanner;

public class NQueens {

    public static void placeNQueens(int n) {
        int[][] board = new int[n][n];
        int[] leftDia = new int[30];
        int[] rightDia = new int[30];
        int[] colms = new int[30];
        placeQueens(n, 0, board, leftDia, rightDia, colms);
    }

    private static void placeQueens(int n, int col, int[][] board, int[] leftDia, int[] rightDia, int[] colms) {
        if (col == n) {
            //valid board configuration
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((leftDia[i - col + n - 1] != 1 && rightDia[i + col] != 1) && colms[i] != 1) {
                board[i][col] = 1;
                leftDia[i - col + n- 1] = rightDia[i + col] = colms[i] = 1;

                placeQueens(n, col + 1, board, leftDia, rightDia, colms);

                board[i][col] = 0;
                leftDia[i - col + n- 1] = rightDia[i + col] = colms[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number of Queens : ");
        int queen = s.nextInt();
        placeNQueens(queen);
    }
}
