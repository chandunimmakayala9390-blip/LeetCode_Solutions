class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> str = new ArrayList<>();
        int open = 0;
        StringBuilder sb = new StringBuilder();
        rec(0,2*n,open,str,sb);
        return str;
    }
    private static void rec(int i, int n, int open, List<String> str,StringBuilder sb){
        if(open < 0 || open > n) return;
        if(i == n) {
            if(open == 0) {
                str.add(sb.toString());
            }
            return;
        }
        sb.append('(');
        rec(i + 1, n, open + 1, str, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        rec(i + 1, n, open - 1, str, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}