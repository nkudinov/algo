package g;

import java.util.*;

public class q14 {
    static  public List<String> helper(int len){
        if (len <= 0){
            return new ArrayList<>();
        } else if ( len == 1) {
            return Arrays.asList(new String[]{"0","1","8"});
        } else if( len == 2){
            return Arrays.asList(new String[]{"69","88","96"});
        } else {
            List<String> lst = new ArrayList<>();
            for(String num:helper(len-2)){
                lst.add("0" + num + "0");
                lst.add("1" + num + "1");
                lst.add("6" + num + "9");
                lst.add("8" + num + "8");
                lst.add("9" + num + "6");
            }
            return lst;
        }
    }
    static public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length()-1;
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('6','9');
        mapping.put('9','6');
        mapping.put('1','1');
        mapping.put('0','0');
        mapping.put('8','8');
        while ( i <= j){
            char ch1 = num.charAt(i);
            char ch2 = num.charAt(j);
            if ( mapping.getOrDefault(ch1, '.') != ch2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        for(String s:helper(5)){
            System.out.println(s);
        }
    }
}
