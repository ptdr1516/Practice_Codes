package DynamicProgramming;

public class EditDistance {

    public static int EditDistanceDP(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        //For first row
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        //for first column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        //To fill dp[i][j]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(m - i) == str2.charAt(n - j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s= "abc";
        String t= "dc";
        System.out.println(EditDistanceDP(s,t));
    }
}
