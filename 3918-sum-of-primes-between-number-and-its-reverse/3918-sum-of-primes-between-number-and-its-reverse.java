class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev=0;
        int n1=n;
        while(n1>0){
            rev=rev*10+n1%10;
            n1=n1/10;
        }
        int ans = 0;
        for(int i = Math.min(rev,n); i<=Math.max(rev,n); i++){
            if(isprime(i))ans+=i;
        }
        return ans;
    }
    public static boolean isprime(int n){
        if(n==0 || n==1)return false;
        for(int i = 2; i * i <= n; i++){
            if(n%i==0)return false;
        }
        return true;
    }
}