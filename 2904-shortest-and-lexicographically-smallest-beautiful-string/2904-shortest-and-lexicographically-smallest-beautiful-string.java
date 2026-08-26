class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String result = "";
        boolean first = true;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int no_of_ones = 0;
            for (int j = i; j < n; j++){
                sb.append(s.charAt(j));
                if(s.charAt(j) == '1'){
                    no_of_ones++;
                }
                if(no_of_ones == k){
                    break;
                }
            }
            if(no_of_ones < k) continue;
            if(first) {
                result = sb.toString();
                first = false; 
            }
            else {
                if(sb.length() < result.length()) {
                    result = sb.toString();
                }
                else if(sb.toString().compareTo(result) < 0 && sb.length() == result.length()){
                    result = sb.toString();
                }
            }
        }
        return result;
    }
}