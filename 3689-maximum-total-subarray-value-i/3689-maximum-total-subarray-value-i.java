class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int max=nums[0],min=nums[0];
        for(int i = 1; i < n; i++){
            if(max<nums[i])max=nums[i];
            if(min>nums[i])min=nums[i];
        }
        return (long)k*(max-min);
    }
}