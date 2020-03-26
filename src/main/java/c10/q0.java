package c10;

import java.util.Arrays;

public class q0 {
   static void swap(int i, int j, int[] arr){
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
   }
   static int[] bsort(int[] arr) {
     for( int i = arr.length-1; i >=0; i--){
        for( int j = 0; j < i; j++){
            if (arr[j] > arr[j+1])
                swap(j,j+1,arr);
        }
     }
     return arr;
   }
    static int[] isort(int[] arr) {
        for( int i = arr.length-1; i >=0; i--){
            int index  = 0;
            for( int j = 0; j <= i; j++){
                if (arr[index] < arr[j])
                    index = j;
            }
            swap(i, index, arr);
        }
        return arr;
    }
    private static int[] merge(int[] a, int[] b){
        int[] ret = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        int e = 0;
        while ( i < a.length && j < b.length) {
            if ( a[i] < b[j] ){
                e = a[i];
                i +=1;
            } else {
                e = b[j];
                j +=1;
            }
            ret[k] = e;
            k +=1;
        }
        while(i < a.length){
            ret[k] = a[i];
            k +=1;
            i +=1;
        }
        while(j < b.length){
            ret[k] = b[j];
            k +=1;
            j +=1;
        }
        return ret;
    }
    static int[] msort(int[] arr) {
         if (arr.length > 2 ){
           int m  = arr.length/2;
           int[] a = Arrays.copyOfRange(arr,0,m);
           int[] b = Arrays.copyOfRange(arr,m,arr.length);
           return merge(a,b);
         } else
           return arr;
    }
    static int[] qsort(int[] arr) {
        return arr;
    }
    static int binarySearch(int[] a, int x){
       int start = 0;
       int end   = a.length-1;
       int m = 0;
      while( start <= end) {
          m = (start + end)/2;
          if (a[m] == x)
              return m;
          else if ( a[m] < x) {
              start = m+1;
          }
          else {
              end = m-1;
          }

      }
      return -1;
    }
    public static void main(String[] args) {
       int [] arr = {10,2,1000,0,2,-11};
       // System.out.println(Arrays.toString(bsort(arr)));
       // System.out.println(Arrays.toString(isort(arr)));
       // System.out.println(Arrays.toString(msort(arr)));
        int[] arr2 = {-11, 0, 2, 2, 10, 1000};
       System.out.println(binarySearch(arr2,1000));
   }
}
