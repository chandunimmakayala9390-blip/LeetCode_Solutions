import java.util.*;
class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap<>();
        String s ="balon";
        for(int i = 0; i < 5; i++) {
            map.put(s.charAt(i),0);
        }
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == 'b') {
                map.put('b',map.get('b')+1);
            }
            else if(text.charAt(i) == 'a') {
                map.put('a',map.get('a')+1);
            }
            else if(text.charAt(i) == 'l') {
                map.put('l',(map.get('l')+1));
            }
            else if(text.charAt(i) == 'o') {
                map.put('o',(map.get('o')+1));
            }
            else if(text.charAt(i) == 'n') {
                map.put('n',map.get('n')+1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (char c : map.keySet()) {
            if(c == 'l' || c == 'o') {
                map.put(c,map.get(c)/2);
            }
            min = Math.min(map.get(c),min);
        }
        return min;
    }
}