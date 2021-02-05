package l100;

import java.util.ArrayList;
import java.util.List;

public class q29 {
    public static List<String> letterCasePermutation(String s) {
        List<StringBuilder> tmp = new ArrayList<>();
        tmp.add(new StringBuilder());
        for(char ch:s.toCharArray()){
            int  size = tmp.size();
            for (int j = 0; j < size; j++) {
                if (Character.isDigit(ch)){
                    tmp.get(j).append(ch);
                } else {
                    StringBuilder sb1 =  tmp.get(j);
                    StringBuilder sb2 = new StringBuilder(sb1);
                    sb1.append(Character.toLowerCase(ch));
                    if (Character.isLetter(ch)){
                        sb2.append(Character.toUpperCase(ch));
                        tmp.add(sb2);
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(StringBuilder sb:tmp){
            ans.add(sb.toString());
        }
        return ans;
    }
    public static void main(String[] args) {
       for(String s:letterCasePermutation("a1b2")){
           System.out.println(s);
       }
    }

}
