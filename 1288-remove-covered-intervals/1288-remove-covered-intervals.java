class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int m = intervals.length;
        int count = m;
        for (int i = 0; i < m; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            for (int j = 0; j < m; j++) {
                if(j == i) continue;
                if (intervals[j][0] <= a && b <= intervals[j][1]){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}