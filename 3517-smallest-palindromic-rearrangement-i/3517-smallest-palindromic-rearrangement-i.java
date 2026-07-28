import java.util.*;
class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if (n == 1 || n == 2) return s;
        StringBuilder sb = new StringBuilder();
        int mid = (n / 2);
        for (int i = 0; i < mid; i++){
            sb.append(s.charAt(i));
        }
        char arr[] = sb.toString().toCharArray();
        Arrays.sort(arr);
        sb = new StringBuilder(new String(arr));
        if(n % 2 != 0) sb.append(s.charAt(mid));
        for (int i = mid - 1; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return sb.toString();
    }
}