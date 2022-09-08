package DynamicProgramming;

public class MaximumSquareMatrixWithAllZeros {

    public static int findMaxSquareMatrixWithAllZeros(int[][] input) {
        if (input.length == 0) {
            return 0;
        }

        int n = input.length;
        int m = input[0].length;

        int[][] dp = new int[n][m];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (input[i][0] == 0) {
                dp[i][0] = 1;
            }
            else {
                dp[i][0] = 0;
            }
            if (max < dp[i][0]) {
                max = dp[i][0];
            }
        }

        for (int i = 0; i < m; i++) {
            if (input[0][i] == 0) {
                dp[0][i] = 1;
            }
            else {
                dp[0][i] = 0;
            }
            if (max < dp[0][i]) {
                max = dp[0][i];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (input[i][j] == 0) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
                else {
                    dp[i][j] = 0;
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] input = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        System.out.println(findMaxSquareMatrixWithAllZeros(input));
    }
}
