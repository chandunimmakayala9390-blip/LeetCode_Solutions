class Solution {
    public int mirrorFrequency(String s) {
        int freq[]=new int[26];
        int freqd[]=new int[10];
        for(char c:s.toCharArray())
        {
            if(c>='a' && c<='z')
            freq[c-'a']++;
            else 
            freqd[c-'0']++;
        }
        int sum=0;
        boolean done[]=new boolean[26];
        boolean doned[]=new boolean[10];
        for(char c:s.toCharArray())
        {
            if(c>='a' && c<='z' && !done[c-'a'])
            {
                sum+=Math.abs(freq[c-'a']-freq['z'-c]);
                done[c-'a']=true;
                done['z'-c]=true;
            }
            else if(c>='0' && c<='9' && !doned[c-'0'])
            {
                sum+=Math.abs(freqd[c-'0']-freqd['9'-c]);
                doned[c-'0']=true;
                doned['9'-c]=true;
            }
        }
        return sum;
    }
}