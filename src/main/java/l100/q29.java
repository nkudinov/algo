package l100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q29 {
    public static List<String> letterCasePermutation1(String s) {
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
    public static List<String> letterCasePermutation(String S) {
        int N = S.length();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < (1<<N); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < N; j++){
                char ch = S.charAt(j);
                if ( (i & (1<<j)) == 0){
                    sb.append(Character.toLowerCase(ch));
                }else {
                    sb.append(Character.toUpperCase(ch));
                }
            }
            set.add(sb.toString());
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
       for(String s:letterCasePermutation("a1b2")){
           System.out.println(s);
       }
    }

}
