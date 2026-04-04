class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows==1 || encodedText=="")return encodedText;
        StringBuilder result=new StringBuilder();
        int cols=encodedText.length()/rows;
        for(int k=0;k<cols;k++)
        {
            int i=0;
            int j=k;
            while(i<rows && j<cols)
            {
                result.append(encodedText.charAt(i*cols+j));
                i++;
                j++;
            }
        }

        return result.toString().stripTrailing();
    }
}