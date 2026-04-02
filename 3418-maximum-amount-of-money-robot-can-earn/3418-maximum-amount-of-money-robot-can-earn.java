import java.util.*;

class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        // dp[i][j][k] → max coins at (i,j) using k neutralizations
        int[][][] dp = new int[m][n][3];

        // Initialize with very small values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        // Base case (0,0)
        if (coins[0][0] >= 0) {
            dp[0][0][0] = coins[0][0];
        } else {
            dp[0][0][0] = coins[0][0]; // don't neutralize
            dp[0][0][1] = 0;           // neutralize
        }

        // Fill DP
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                for (int k = 0; k <= 2; k++) {

                    int best = Integer.MIN_VALUE;

                    // From top
                    if (i > 0 && dp[i - 1][j][k] != Integer.MIN_VALUE) {
                        best = Math.max(best, dp[i - 1][j][k] + coins[i][j]);
                    }

                    // From left
                    if (j > 0 && dp[i][j - 1][k] != Integer.MIN_VALUE) {
                        best = Math.max(best, dp[i][j - 1][k] + coins[i][j]);
                    }

                    dp[i][j][k] = Math.max(dp[i][j][k], best);

                    // If current cell is negative → try neutralizing
                    if (coins[i][j] < 0 && k > 0) {

                        // From top with k-1
                        if (i > 0 && dp[i - 1][j][k - 1] != Integer.MIN_VALUE) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1]);
                        }

                        // From left with k-1
                        if (j > 0 && dp[i][j - 1][k - 1] != Integer.MIN_VALUE) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1]);
                        }
                    }
                }
            }
        }

        // Final answer
        int ans = Integer.MIN_VALUE;
        for (int k = 0; k <= 2; k++) {
            ans = Math.max(ans, dp[m - 1][n - 1][k]);
        }

        return ans;
    }
}