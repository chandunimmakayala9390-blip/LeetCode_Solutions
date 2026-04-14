import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int m = robot.size();
        int n = factory.length;

        long[][] dp = new long[m + 1][n + 1];

        // Initialize with large value
        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        // Base case: no robots → 0 distance
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int j = 1; j <= n; j++) {
            int position = factory[j - 1][0];
            int capacity = factory[j - 1][1];

            for (int i = 0; i <= m; i++) {
                dp[i][j] = dp[i][j - 1];

                long dist = 0;

                for (int k = 1; k <= capacity && i - k >= 0; k++) {
                    dist += Math.abs(robot.get(i - k) - position);

                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j],
                            dp[i - k][j - 1] + dist);
                    }
                }
            }
        }

        return dp[m][n];
    }
}