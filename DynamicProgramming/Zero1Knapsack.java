package DynamicProgramming;

public class Zero1Knapsack {

    /*Recursive*/
    public static int knapSack(int[] weights, int[] values, int maxWeight) {
        return knapSack(weights, values, maxWeight, 0);
    }

    public static int knapSack(int[] weights, int[] values, int maxWeight, int i) {
        if (i == weights.length || maxWeight == 0) {
            return 0;
        }

        if (weights[i] > maxWeight) {
            return knapSack(weights, values, maxWeight, i + 1);
        }
        else {
            // including ith item
            int ans1 = values[i] + knapSack(weights, values, maxWeight - weights[i], i + 1);
            // excluding ith item
            int ans2 = knapSack(weights, values, maxWeight, i + 1);

            return Math.max(ans1, ans2);
        }
    }

    /*Memoization*/
    public static int knapsack(int W, int val[], int[] wt) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int w = 0; w <= W; w++) {
                int ans;
                if (wt[i] <= w) {
                    int ans1 = val[i] + dp[i + 1][w - wt[i]];
                    int ans2 = dp[i + 1][w];
                    ans = Math.max(ans1, ans2);
                }
                else {
                    ans = dp[i][w];
                }
                dp[i][w] = ans;
            }
        }
        return dp[0][W];
    }

    public static void main(String[] args) {
        int val[] = {200, 300, 100};
        int wt[] = {20, 25, 30};
        int W = 50;
        int ans = knapsack(W, val, wt);
        System.out.println(ans);
    }
}
