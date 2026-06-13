class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char ans[] = new char[words.length];
        int count=0;
        for(String str : words){
            int w=0;
            for(int i=0; i<str.length();i++){
                w+=weights[str.charAt(i)-'a'];
            }
            w %=26;
            ans[count++]=(char)('z'- w);
        }
        String res=new String(ans);
        return res;
    }
}