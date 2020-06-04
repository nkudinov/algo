package lc.june2020;

import java.util.Arrays;

public class q4 {
    static public void reverseString(char[] s) {
       int i = 0;
       while( i < s.length/2 ){
          char tmp = s[i];
          s[i] = s[s.length-i-1];
          s[s.length-i-1] = tmp;
          i++;
       }
    }
    public static void main(String[] args) {
       char[] arr = new char[]{'h','e','l','l','o'};
       reverseString(arr);
       System.out.println(Arrays.toString(arr));
    }
}
