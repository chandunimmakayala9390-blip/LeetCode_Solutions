class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int rows=mat.length;
        int cols=mat[0].length;
        boolean val=true;
        int shifts=k%cols;
        if(shifts==0)return true;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(i%2==0)
                {
                    int x=j+shifts;
                    if(x>=cols)
                    x=x%cols;
                    if(mat[i][j]!=mat[i][x])
                    {
                        val=false;
                        break;
                    }
                }
                else 
                {
                    int x=(cols-shifts+j)%cols;
                    if(mat[i][j]!=mat[i][x])
                    {
                        val=false;
                        break;
                    }
                }
            }
        }
        return val;
    }
}