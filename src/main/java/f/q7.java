package f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q7 {
    public static String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        Map<Character,Integer> m = new HashMap<>();
        for(Character ch:t.toCharArray()){
            m.merge(ch, 1, (a,b) -> a + b);
        }
        int left  = 0;
        int minLeft = left;
        int minLen  = s.length() + 1;
        int count = 0;
        for( int j  = 0; j < s.length(); j++){
           Character ch = s.charAt(j);
           if (m.containsKey(ch)){
                m.merge(ch, -1, (a,b) -> a +b );
                if (m.get(ch) >= 0){
                    count++;
                }
               while(count == t.length()){
                   Character leftChar = s.charAt(left);
                   if(j-left+1 < minLen){
                       minLeft = left;
                       minLen = j-left+1;
                   }
                   if (m.containsKey(leftChar)){
                       m.merge(leftChar, 1, (a,b) -> a + b);
                       if (m.get(leftChar) > 0){
                           count--;
                       }
                   }
                   left++;
               }
           }

        }
        return s.substring( minLeft, minLeft + minLen);
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
