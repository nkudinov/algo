package f;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q6 {

   static int matchingPairs(String s, String t) {
        int ret  = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Set<Character> characters = new HashSet<>();
        boolean hasDub = false;
        for( int i = 0; i < s.length(); i++){
            if (s.charAt(i) == t.charAt(i)){
                ret++;
            } else {
                sb1.append(s.charAt(i));
                sb2.append(t.charAt(i));
            }
            if ( !characters.add(s.charAt(i)) ){
                   hasDub = true;
            }
        }
        if (sb1.length() == 0){
            if (hasDub)
                return ret;
            return ret - 2;
        }
        //"fg"
        //"gf"
        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();
        for(int i = 0; i < sb1.length();i++){
           if ( m1.getOrDefault(sb2.charAt(i),-1) == m1.getOrDefault(sb2.charAt(i),-1)){
               return ret +2;
           }
           m1.put(sb1.charAt(i),i);
           m2.put(sb2.charAt(i),i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(matchingPairs("mno","mno"));
        System.out.println(matchingPairs("mmno","mmno"));
        System.out.println(matchingPairs("abcd","adcb"));
    }
}
