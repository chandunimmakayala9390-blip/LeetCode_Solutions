import java.util.*;
class Solution {

    public List<Integer> findMissingElements(int[] nums) {
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < small) {
                small = nums[i];
            }
            if (large < nums[i]) {
                large = nums[i];
            }
        }
        Arrays.sort(nums);
        ArrayList<Integer>lis=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=small)
            {
                lis.add(small);
                i--;
                small++;
            }
            else {
                small++;
            }
        }
        return lis;
    }
}
