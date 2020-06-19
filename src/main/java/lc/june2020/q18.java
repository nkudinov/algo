package lc.june2020;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class q18 {
    static public int hIndex(int[] citations) {
       int ret = 0;
       for(int i = 1;i <= citations.length; i++){
          if ( i <= citations[citations.length-i] ){
              ret =  i;
          }
       }
       return ret;
    }
    public static void main(String[] args) {
      int[] arr = new int [] {100};
      System.out.println(hIndex(arr));
    }
}
