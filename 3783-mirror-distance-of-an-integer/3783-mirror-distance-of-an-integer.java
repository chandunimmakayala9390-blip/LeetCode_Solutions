class Solution {
    public int mirrorDistance(int n) {
        int r=reverse(n);
        return Math.abs(n-r);
    }
    private  static int reverse(int n){
        int res =0;
        while(n>0){
            res=res*10+n%10;
            n=n/10;
        }
        return res;
    }
}