import java.util.Arrays;
class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean seen[]=new boolean[nums.length+1];
        seen[0]=true;
        int n=nums.length;
        int res[]=new int[2];
        for(int i=0;i<n;i++)
        {
            if(!seen[nums[i]])
            seen[nums[i]]=true;
            else 
            res[0]=nums[i];
        }
        for(int i=1;i<=n;i++)
        {
            if(!seen[i])
            {
                res[1]=i;
                break;
            }
        }
        return res;
    }
}