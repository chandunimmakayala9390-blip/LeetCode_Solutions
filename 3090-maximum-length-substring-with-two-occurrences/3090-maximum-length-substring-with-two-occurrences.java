import java.util.*;
class Solution {
    public int maximumLengthSubstring(String s) {
        int maxlen = 0;
        int l = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0) + 1);
            while (l <= r && map.get(s.charAt(r)) > 2){
                map.put(s.charAt(l),map.get(s.charAt(l)) - 1);
                l++;
            }
            maxlen = Math.max(r - l + 1, maxlen);
        }
        return maxlen;
    }
}