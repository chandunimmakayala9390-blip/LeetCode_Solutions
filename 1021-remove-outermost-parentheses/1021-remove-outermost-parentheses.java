class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        int st = 0;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '(' ){
                balance++;
            }
            else {
                balance--;
            }
            if(balance == 0){
                end = i;
                sb.append(s.substring(st + 1,end));
                st = i + 1;
            }
        }
        return sb.toString();
    }
}