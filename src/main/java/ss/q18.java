package ss;

import java.util.Arrays;
import java.util.Collections;

public class q18 {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length-1; i >=0 ;i--){
            if (words[i].trim().length() == 0){
                continue;
            }
            sb.append(words[i]);
            if ( i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "  hello world  ";
        System.out.println(reverseWords(str));
    }
}
