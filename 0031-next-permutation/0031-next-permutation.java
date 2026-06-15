import java.util.*;
class Solution {
    public void nextPermutation(int[] nums) {
        // Your code goes here
        int index = -1;
        boolean found = false;
        for (int i = nums.length -2; i >= 0; i--){
            if (nums[i] < nums[i+1]){
                found = true;
                index = i;
                break;
            }
        }
        if(!found) {
            Arrays.sort(nums);
        }
        else {
            for (int i = nums.length - 1; i > index; i--) {
                if(nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
            int left = index + 1;
            int right = nums.length - 1;
            while(left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}