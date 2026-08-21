import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int size = 1 << n;
        long[] subsetLcm = new long[size];
        
        // Precompute LCM for every non-empty subset
        for (int mask = 1; mask < size; mask++) {
            int lowBit = mask & (-mask);
            int idx = Integer.numberOfTrailingZeros(lowBit);
            int prevMask = mask ^ lowBit;
            if (prevMask == 0) {
                subsetLcm[mask] = coins[idx];
            } else {
                long a = subsetLcm[prevMask];
                long b = coins[idx];
                long g = gcd(a, b);
                // cap to avoid overflow; once lcm exceeds our search bound it contributes 0 anyway
                if (a / g > Long.MAX_VALUE / b) {
                    subsetLcm[mask] = Long.MAX_VALUE / 2; // effectively "too large"
                } else {
                    subsetLcm[mask] = (a / g) * b;
                }
            }
        }
        
        int minCoin = Integer.MAX_VALUE;
        for (int c : coins) minCoin = Math.min(minCoin, c);
        
        long lo = 1, hi = (long) minCoin * (long) k;
        
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (countLE(mid, subsetLcm, n) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
    
    private long countLE(long x, long[] subsetLcm, int n) {
        long total = 0;
        int size = 1 << n;
        for (int mask = 1; mask < size; mask++) {
            long l = subsetLcm[mask];
            if (l > x) continue;
            long term = x / l;
            int bits = Integer.bitCount(mask);
            if ((bits & 1) == 1) {
                total += term;
            } else {
                total -= term;
            }
        }
        return total;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}