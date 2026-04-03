import java.util.*;

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        int[][] bots = new int[n][2];
        for (int i = 0; i < n; i++) {
            bots[i][0] = robots[i];
            bots[i][1] = distance[i];
        }
        Arrays.sort(bots, (a, b) -> a[0] - b[0]);

        int[] W = walls.clone();
        Arrays.sort(W);

        int[][] botsFull = new int[n + 2][2];
        botsFull[0] = new int[]{Integer.MIN_VALUE / 2, 0};
        for (int i = 0; i < n; i++) botsFull[i + 1] = bots[i];
        botsFull[n + 1] = new int[]{Integer.MAX_VALUE / 2, 0};

        int total = botsFull.length;

        // Walls sitting exactly on a robot are destroyed for free
        // Count them separately so they don't fall into gap logic
        int freeWalls = 0;
        {
            Set<Integer> robotPositions = new HashSet<>();
            for (int[] b : bots) robotPositions.add(b[0]);
            Set<Integer> counted = new HashSet<>();
            for (int w : W) {
                if (robotPositions.contains(w) && counted.add(w)) {
                    freeWalls++;
                }
            }
        }

        int[] LL = new int[total - 1];
        int[] RR = new int[total - 1];
        int[] OO = new int[total - 1];

        for (int i = 0; i < total - 1; i++) {
            int lpos = botsFull[i][0],  ldist = botsFull[i][1];
            int rpos = botsFull[i + 1][0], rdist = botsFull[i + 1][1];

            // Walls STRICTLY between lpos and rpos (walls ON robots handled above)
            int a = upperBound(W, lpos);      // first index > lpos
            int b = lowerBound(W, rpos);      // first index >= rpos  → excludes rpos

            if (a >= b) continue;

            int gapLen = b - a;
            int[] gap = Arrays.copyOfRange(W, a, b);

            long leftReach  = (long) lpos + ldist;
            long rightReach = (long) rpos - rdist;

            LL[i] = upperBound(gap, (int) Math.min(leftReach,  (long)(Integer.MAX_VALUE)));
            RR[i] = gapLen - lowerBound(gap, (int) Math.max(rightReach, (long)(Integer.MIN_VALUE)));

            if (leftReach >= rightReach) {
                int ol  = lowerBound(gap, (int) Math.max(rightReach, (long)(Integer.MIN_VALUE)));
                int or_ = upperBound(gap, (int) Math.min(leftReach,  (long)(Integer.MAX_VALUE)));
                OO[i] = Math.max(0, or_ - ol);
            }
        }

        long f = 0;
        long g = Long.MIN_VALUE / 2;

        for (int i = 1; i < total - 1; i++) {
            int gapLeft  = i - 1;
            int gapRight = i;

            long newF = Math.max(f, g) + LL[gapRight];
            long newG = Math.max(
                f + RR[gapLeft] - OO[gapLeft],
                g + RR[gapLeft]
            );

            f = newF;
            g = newG;
        }

        return (int) Math.max(f, g) + freeWalls;
    }

    private int upperBound(int[] W, int val) {
        int lo = 0, hi = W.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (W[mid] <= val) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int lowerBound(int[] W, int val) {
        int lo = 0, hi = W.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (W[mid] < val) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}