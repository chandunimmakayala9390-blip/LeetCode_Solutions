class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            min = Math.min(nums[i],min);
            max = Math.max(nums[i],max);
        }
        return gcd(max,min);
    }
    private static int gcd(int a, int b){
        if (a < b) return gcd(b, a);
        if(b == 0)return a;
        return gcd(b, a%b);
    }
}