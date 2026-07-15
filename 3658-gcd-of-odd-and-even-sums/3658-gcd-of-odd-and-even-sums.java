class Solution {
    public int gcdOfOddEvenSums(int n) {
        int val1 = n * (n + 1);
        int val2 = n * n;
        return gcd(val1,val2);
    }
    private static int gcd(int a, int b) {
        if(a < b) return gcd(b , a);
        if(b == 0) return a;
        return gcd(b,a%b);
    }
}