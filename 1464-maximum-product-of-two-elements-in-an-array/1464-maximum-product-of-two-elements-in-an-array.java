class Solution {
    public int maxProduct(int[] nums) {
        int first_max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > first_max) {
                second_max = first_max;
                first_max = nums[i];
            }
            else if(nums[i] > second_max){
                second_max = nums[i];
            }
        }
        return (first_max - 1) * (second_max - 1);
    }
}