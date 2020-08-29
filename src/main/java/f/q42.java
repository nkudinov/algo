package f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q42 {
   static HashMap<Character, String> phone = new HashMap<Character,String >() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    static private void helper(String digits, List<String>  list, String curr){
          if (digits == null || digits.length() == 0){
              list.add(curr);
          } else {
              Character digit = digits.charAt(0);
              String letters = phone.get(digit);
              for (char letter : letters.toCharArray()) {
                  helper(digits.substring(1), list, curr + letter);
              }
          }
    }
    static public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return ret;
        }
        helper(digits, ret,"");
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}

