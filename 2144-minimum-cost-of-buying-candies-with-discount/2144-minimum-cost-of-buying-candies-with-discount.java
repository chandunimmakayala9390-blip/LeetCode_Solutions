class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int min=0;
        int i=cost.length-1;
        int count=0;
        while(i>=0){
            if(count==2){
                i--;
                count=0;
                continue;
            }
            else{
                min+=cost[i];
                count++;
                i--;
            }
        }
        return min;
    }
}