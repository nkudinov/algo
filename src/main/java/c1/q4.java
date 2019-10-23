package c1;

import java.util.Arrays;

public class q4 {
 public static char[] replaceBlanks(char[] arr){
     int cnt = arr.length;
     for(char ch:arr){
         if (ch==' ') {
             cnt += 2;
         }
     }
     int i =0;
     char[] c = new char[cnt];
     for(char ch:arr){
         if (ch==' '){
            c[i++] = '%';
            c[i++] = '2';
            c[i++] = '0';
         } else {
            c[i++] = ch;
         }
     }
     return c;
 }
}
