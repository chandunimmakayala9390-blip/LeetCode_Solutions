class Solution {
    public int pivotInteger(int n) {
        int pivot=-1;
        for(int i=1;i<=n;i++)
        {
            if((n*(n+1)/2)-(i*(i+1)/2)+i==(i*(i+1)/2)){
                pivot=i;
                break;
            }
        }
        return pivot;
    }
}