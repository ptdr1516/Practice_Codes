package DynamicProgramming;

public class WaysToMakeCoinChange {

    public static int countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;
        int[][] dp = new int[n][value + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= value; j++) {
                dp[i][j] = -1;
            }
        }
        int c = count(denominations, 0, value, dp);
        return c;
    }

    public static int count(int[] denominations, int i, int sum, int[][] dp) {
        if (sum == 0) {
            return 1;
        }

        if (i >= denominations.length || sum < 0) {
            return 0;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        int left = count(denominations, i, sum - denominations[i], dp);
        int right = count(denominations,i + 1,sum,dp);

        dp[i][sum] = left + right;

        return dp[i][sum];
    }

    public static void main(String[] args) {
        int coins[] = {1,2,3,4,5,6};
        int val = 250;
        System.out.println(countWaysToMakeChange(coins, val));
    }
}
