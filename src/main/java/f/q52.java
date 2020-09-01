package f;

import scala.Int;

import java.util.HashSet;
import java.util.Set;

public class q52 {
    static public void helper(String s, Set<String> acc, String curr){
        if (s == null || s.length() == 0){
            acc.add( curr);
        } else {
            if (s.charAt(0) != '0'){
                String  str1 = s.substring(0,1);
                Integer val1 = Integer.valueOf(str1);
                helper( s.substring(1), acc, curr+(char)('A'+val1-1));
                if (s.length() >=2){
                    String str2 =  s.substring(0,2);
                    Integer val2 = Integer.valueOf(str2);
                    if (val2 <= 26) {
                        helper( s.substring(2), acc, curr+(char)('A'+val2-1));
                    }
                }
            }
        }
    }
    static public int numDecodings(String s) {
        Set<String> set = new HashSet<>();
        helper(s, set,"");
        return set.size();
    }
    public static void main(String[] args) {
     //   System.out.println("22".substring(0,1));
        System.out.println(numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
    }

}
