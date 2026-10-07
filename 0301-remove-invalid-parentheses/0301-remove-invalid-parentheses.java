class Solution {

    public List<String> removeInvalidParentheses(String s) {
        int moves = 0;
        Stack<Character> st = new Stack<>();

        // Find minimum number of removals
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else if (s.charAt(i) == ')') {
                if (st.isEmpty()) {
                    moves++;
                } else {
                    st.pop();
                }
            }
        }

        int removals = moves + st.size();

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        recursive(0, s.length(), s, sb, res, 0, removals);

        // Remove duplicates
        return new ArrayList<>(new HashSet<>(res));
    }

    private void recursive(int i, int n, String s, StringBuilder sb, List<String> res, int balance, int removals) {
        // Too many removals
        if (removals < 0) {
            return;
        }

        // Reached end
        if (i == n) {
            if (balance == 0 && removals == 0) {
                res.add(sb.toString());
            }

            return;
        }

        char ch = s.charAt(i);

        // ---------------- LETTER ----------------

        if (ch >= 'a' && ch <= 'z') {
            sb.append(ch);

            recursive(i + 1, n, s, sb, res, balance, removals);

            sb.deleteCharAt(sb.length() - 1);
        }
        // ---------------- '(' ----------------

        else if (ch == '(') {
            // OPTION 1: Remove '('
            recursive(i + 1, n, s, sb, res, balance, removals - 1);

            // OPTION 2: Keep '('
            sb.append('(');

            recursive(i + 1, n, s, sb, res, balance + 1, removals);

            sb.deleteCharAt(sb.length() - 1);
        }
        // ---------------- ')' ----------------

        else {
            // OPTION 1: Remove ')'
            recursive(i + 1, n, s, sb, res, balance, removals - 1);

            // OPTION 2: Keep ')'
            // Only possible if there is a '(' available
            if (balance > 0) {
                sb.append(')');

                recursive(i + 1, n, s, sb, res, balance - 1, removals);

                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
