import java.util.Arrays;

class Solution {

    public int minimumDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        if (n < 3) return -1;

        for (int i = 0; i < n; i++) {
            int first = i;

            // collect all matching indices
            int[] temp = new int[n];
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[first] && j != first) {
                    temp[count++] = j;
                }
            }

            // try all pairs of second & third
            for (int x = 0; x < count; x++) {
                for (int y = x + 1; y < count; y++) {
                    int second = temp[x];
                    int third = temp[y];

                    int tot = Math.abs(first - second) + Math.abs(second - third) + Math.abs(third - first);

                    min = Math.min(min, tot);
                }
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}
