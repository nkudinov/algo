package c11;

import java.util.Arrays;

public class q1 {

    static void merge(int[] a, int[] b) {
      int i = a.length-b.length-1;
      int j = b.length-1;
      for(int k = a.length-1; k >= 0; k--){

          if (j >= 0 && i>=0 ){
              if ( a[i] > b[j] ){
              a[k] = a[i];
              i--;
          } else {
              a[k] = b[j];
              j--;
          }

      }
    }

    public static void main(String[] args) {
        int[] a = {10,20,30,0,0};
        int[] b = {1,2};
        merge(a, b);
        System.out.println(Arrays.toString(a));
    }

}
