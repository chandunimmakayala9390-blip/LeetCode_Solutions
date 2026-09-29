class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if((m + n - 1) % 2 != 0) return false;
        if(grid[0][0] == ')') return false;
        Boolean dp[][][] = new Boolean [m][n][m + n];
        int i = 0,j = 0,open = 1;
        return recursion(i,j,open,m,n,grid,dp);
    }
    private static boolean recursion(int i, int j, int open, int m, int n,char grid[][], Boolean dp[][][]){
        if(open < 0) return false;
        if(i == m - 1 && j == n - 1 && open == 0) {
            return true;
        }
        if(dp[i][j][open] != null) return dp[i][j][open];
        // move down 
        if(i + 1 < m) {
            if(grid[i + 1][j] == '('){
                int newopen = open;
                newopen++;
                if(recursion(i + 1 ,j ,newopen,m,n,grid,dp)){
                    return true;
                }
            }
            else {
                int newopen = open;
                newopen--;
                if(recursion(i + 1 ,j ,newopen,m,n,grid,dp)){
                    return true;
                }
            }
        }
        // move right
        if(j + 1 < n) {
            if(grid[i][j + 1] == '('){
                int newopen = open;
                newopen++;
                if(recursion(i ,j + 1,newopen,m,n,grid,dp)){
                    return true;
                }

            }
            else {
                int newopen = open;
                newopen--;
                if(recursion(i,j + 1,newopen,m,n,grid,dp)){
                    return true;
                }
            }
        }
        return dp[i][j][open] = false;
    }
}