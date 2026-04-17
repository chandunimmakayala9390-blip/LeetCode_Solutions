import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        // Map from reversed value -> most recent index seen
        Map<Integer, Integer> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int rev = reverse(nums[i]);
            
            // Check if current number was seen as a reversed value before
            if (map.containsKey(nums[i])) {
                minDist = Math.min(minDist, i - map.get(nums[i]));
                // Early exit: distance of 1 is impossible to beat
                if (minDist == 1) return 1;
            }
            
            // Store/update: reversed value -> latest index
            // Only keep the latest index (closest to future elements)
            map.put(rev, i);
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    
    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
}