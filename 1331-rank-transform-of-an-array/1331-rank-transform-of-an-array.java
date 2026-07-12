class Solution {
    class pair {
        int val;
        int index;
        pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n == 0) return new int[]{};
        pair p[] = new pair[n];
        for (int i = 0; i < n; i++){
            p[i] = new pair(arr[i], i);
        }
        Arrays.sort(p,(a,b) -> (a.val - b.val));
        int res[] = new int[n];
        res[p[0].index] = 1;
        int last = p[0].val;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if(last == p[i].val){
                res[p[i].index] = res[p[i - 1].index];
            }
            else {
                curr++;
                last = p[i].val;
                res[p[i].index] = curr;
            }
        }
        return res;
    }
}