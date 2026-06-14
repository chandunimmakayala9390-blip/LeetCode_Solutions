class Solution {
    public int getLength(int[] a) {
        int n = a.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
          HashMap<Integer, Integer> mp = new HashMap<>();
            int[] fq = new int[n + 1];
            int mx = 0;
            int s = 0;
            for (int j = i; j < n; j++) {
                int old = mp.getOrDefault(a[j], 0);
                if (old > 0)
                    fq[old]--; // remove old frequency
               mp.put(a[j], old + 1);
                fq[old + 1]++; // add new frequency
                if (old + 1 > mx) {
                    mx = old + 1;
                    s = 1; // new maximum frequency found
                }
                else if (old + 1 == mx) {
                    s++; // another value reaches maximum frequency
                }
                int distinct = mp.size();
                if (distinct == 1) {
                    ans = Math.max(ans, j - i + 1);
                }
                else if (mx % 2 == 0 &&
                         s < distinct &&
                         fq[mx / 2] == distinct - s) {

                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}