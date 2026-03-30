import java.util.*;
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        
        List<Character> s1Even = new ArrayList<>();
        List<Character> s1Odd = new ArrayList<>();
        List<Character> s2Even = new ArrayList<>();
        List<Character> s2Odd = new ArrayList<>();
        
        // Separate even and odd indices
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                s1Even.add(s1.charAt(i));
                s2Even.add(s2.charAt(i));
            } else {
                s1Odd.add(s1.charAt(i));
                s2Odd.add(s2.charAt(i));
            }
        }
        
        // Sort all lists
        Collections.sort(s1Even);
        Collections.sort(s1Odd);
        Collections.sort(s2Even);
        Collections.sort(s2Odd);
        
        // Compare
        return s1Even.equals(s2Even) && s1Odd.equals(s2Odd);
    }
}
