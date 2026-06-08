class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int res[]=new int[n];
        int cl=0,cr=n-1,ce=0;
        int left=0,right=n-1;
        for(int i=0;i<n;i++){
            if(nums[i]==pivot)ce++;
        }
        while(left < n && right >= 0){
            if(nums[left]<pivot){
                res[cl++]=nums[left];
            }
            if(nums[right]>pivot){
                res[cr--]=nums[right];
            }
            left++;
            right--;
        }
        for(int i = 0; i < ce; i++){
            res[cl++]=pivot;
        }
        return res;
    }
}