class Solution {

    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        int n=moves.length();
        for(int i=0;i<n;i++)
        {
            if(moves.charAt(i)=='D'){
                y-=10;
            }
            else if(moves.charAt(i)=='L'){
                x-=10;
            }
            else if(moves.charAt(i)=='R'){
                x+=10;
            }
            else if(moves.charAt(i)=='U'){
                y+=10;
            }
        }
        return x==0 && y==0;
        
    }
}
