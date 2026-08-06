class Solution {
    public int smallestNumber(int n, int t) {
        int i = n;
        while(true){
            if(digit_product(i) % t == 0){
                break;
            }
            i++;
        }
        return i;
    }
    private static int digit_product(int n){
        int product = 1;
        while (n > 0){
            product *= n % 10;
            n = n/10;
        }
        return product;
    }
}