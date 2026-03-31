import java.util.*;
class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        char[] word = new char[len];
        Arrays.fill(word, '?');

        boolean[] fixed = new boolean[len];

        // Step 1: Apply 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;

                    if (word[pos] == '?' || word[pos] == str2.charAt(j)) {
                        word[pos] = str2.charAt(j);
                        fixed[pos] = true;
                    } else {
                        return "";
                    }
                }
            }
        }

        // Step 2: Fill remaining with 'a'
        for (int i = 0; i < len; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // Step 3: Handle 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                // Check if substring equals str2
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // If equal → must break
                if (match) {
                    boolean changed = false;

                    // Try from right to left
                    for (int j = m - 1; j >= 0; j--) {
                        int pos = i + j;

                        if (!fixed[pos]) {
                            // Try smallest possible change
                            for (char c = 'a'; c <= 'z'; c++) {
                                if (c != str2.charAt(j)) {
                                    word[pos] = c;
                                    changed = true;
                                    break;
                                }
                            }
                        }

                        if (changed) break;
                    }

                    // If cannot break → impossible
                    if (!changed) return "";
                }
            }
        }
        return new String(word);
    }
}