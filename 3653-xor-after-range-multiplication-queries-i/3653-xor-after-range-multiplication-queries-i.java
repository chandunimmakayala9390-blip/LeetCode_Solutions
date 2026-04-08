class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;
        int MOD = 1000000007;
        for(int i=0;i<q;i++)
        {
            int idx=queries[i][0];
            while(idx<=queries[i][1])
            {
                nums[idx]=(int)(1L*nums[idx]*queries[i][3]%MOD);
                idx+=queries[i][2];
            }
        }
        int x=nums[0];
        for(int i=1;i<n;i++)
        {
            x=x^nums[i];
        }
        return x;
    }
}