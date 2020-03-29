package lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q3 {
    public static int lengthOfLongestSubstring(String s) {
        int ret =0;
        for(int i =0; i < s.length();i++){
           Set<Character> set = new HashSet<>();
           set.add(s.charAt(i));
           int tmp = 1;
           for(int j = i+1; j< s.length(); j++){
               if (set.contains(s.charAt(j))){
                   break;
               } else{
                   set.add(s.charAt(j));
                   tmp++;
               }
           }
           ret = Math.max(ret,tmp);
       }
       return ret;
    }
    public static int lengthOfLongestSubstring2(String s) {
        int ret = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while( i < s.length() && j < s.length()){
            if ( !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ret = Math.max(ret, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ret;
    }
    public static int lengthOfLongestSubstring3(String s) {
        int ret = 0;
        Map<Character, Integer> m = new HashMap<>();
        for(int i = 0, j = 0; j < s.length();j++){
          if (m.containsKey(s.charAt(j))){
              i = Math.max(i, m.get(s.charAt(j)));
          }
          m.put( s.charAt(j), j + 1);
          ret = Math.max(ret, j - i + 1);
        }
        return ret;
    }
    public static void main(String[] args) {
       // System.out.println(lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3( "abba"));

    }
}
