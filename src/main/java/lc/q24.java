package lc;

import java.util.HashMap;
import java.util.Map;

public class q24 {
    public static int romanToInt(String s) {
        Map<Character,Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        int ret = 0;
        //"IV"
        for( int i  = s.length()-1; i >= 0; i--){
            char ch = s.charAt(i);
            int  vl = m.get(ch);
            if ( i < s.length()-1 ){
                char prev = s.charAt(i+1);
                if ( vl < m.get(prev)){
                    vl = - vl;
                }
            }
            ret += vl;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("IVIII"));
    }
}
