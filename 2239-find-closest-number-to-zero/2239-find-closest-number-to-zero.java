class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];
        int minDist = Math.abs(nums[0]);

        for (int num : nums) {
            int abs = Math.abs(num);

            if (abs < minDist || (abs == minDist && num > closest)) {
                closest = num;
                minDist = abs;
            }
        }

        return closest;
    }
}