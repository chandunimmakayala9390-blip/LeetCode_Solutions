class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int [n];
        int ans[] = new int[n];
        left[0] = 0;
        right[n-1] = 0;
        int i=1,j=n-2;
        while(i <= n-1 && j >= 0){
            left[i]=left[i-1]+nums[i-1];
            right[j]=right[j+1]+nums[j+1];
            i++;
            j--;
        }
        for(int k = 0; k < n; k++){
            ans[k] = Math.abs(left[k]-right[k]);
        }
        return ans;
    }
}