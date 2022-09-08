package DynamicProgramming;

import java.util.Scanner;

public class MinimumCostPath {

    /*Recursive*/
    public static int minCostPathRecursive(int[][] arr) {
        return minCostPathRecursive(arr, 0, 0);
    }

    private static int minCostPathRecursive(int[][] arr, int i, int j) {
        int m = arr.length; //Number of rows
        int n = arr[0].length; //Number of Columns

        if (i == m - 1 && j == n - 1) { //Destination
            return arr[i][j];
        }

        if (i >= m || j >= n) { //Out of bound
            return Integer.MAX_VALUE;
        }

        int op1 = minCostPathRecursive(arr, i, j +1); //Right
        int op2 = minCostPathRecursive(arr, i + 1, j + 1); //Diagonal
        int op3 = minCostPathRecursive(arr, i + 1, j); //Down

        return arr[i][j] + Math.min(op1, Math.min(op2, op3));
    }

    /*Memoization*/
    public static int minCostPathM(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] storage = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                storage[i][j] = -1;
            }
        }
        return minCostPathM(arr, 0, 0, storage);
    }

    private static int minCostPathM(int[][] arr, int i, int j, int[][] storage) {
        int m = arr.length;
        int n = arr[0].length;

        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i >= m - 1 && j == n - 1) {
            storage[m - 1][n - 1] = arr[i][j];
            return storage[i][j];
        }

        if (storage[i][j] != -1) {
            return storage[i][j];
        }

        int op1 = minCostPathM(arr, i, j +1, storage); //Right
        int op2 = minCostPathM(arr, i + 1, j + 1, storage); //Diagonal
        int op3 = minCostPathM(arr, i + 1, j, storage); //Down

        storage[i][j] =  arr[i][j] + Math.min(op1, Math.min(op2, op3));
        return storage[i][j];
    }

    /*Dynamic Programming*/
    public static int minCostPathDP(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = arr[i][j];
                    continue;
                }
                int ans1 = dp[i][j+1];
                int ans2 = dp[i+1][j];
                int ans3 = dp[i+1][j+1];
                dp[i][j] = arr[i][j] + Math.min(ans1, Math.min(ans2, ans3));
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int arr[][]= new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println(minCostPathDP(arr));
    }
}
