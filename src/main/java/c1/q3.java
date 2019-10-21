package c1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q3 {
    private static String sort(String s){
       char[] arr = s.toCharArray();
       Arrays.sort(arr);
       return new String(arr);
    }
    public static boolean isPermutation1(String a, String b ){
        return sort(a).equals(sort(b));
    }

    public static boolean isPermutation2(String a, String b ){
        Map<Character,Integer> dict = new HashMap<>();

        for(char ch:a.toCharArray()){
            Integer oValue = dict.get(ch);
            Integer nValue = oValue == null?0:oValue+1;
            dict.put(ch,nValue);
        }

        for(char ch:b.toCharArray()){
            Integer oValue = dict.get(ch);
            if (oValue == null || oValue == 0){
                return false;
            } else {
                dict.put(ch,oValue-1);
            }
        }
        for(Integer v:dict.values()){
            if (v !=0) {
                return false;
            }
        }
        return true;
    }


}
