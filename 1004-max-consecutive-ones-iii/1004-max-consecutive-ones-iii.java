class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < nums.length; r++){
            if(nums[r] == 0 && k == 0){
                while (l <= r && k == 0){
                    if(nums[l] == 0){
                        k++;
                    }
                    l++;
                }
            }
            if(nums[r] == 0){
                k--;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}