package rest;

import java.util.Arrays;

public class HeapAlgorithm {
    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
    static void generate(int[] arr, int k){
       if ( k==1) {
           System.out.println(Arrays.toString(arr));
           return;
       }
       generate(arr, k-1);
       for(int i = 0; i < k-1 ;i++){
           if (k%2 == 0){
               swap( arr, i, k-1);
           }else {
               swap( arr,0, k-1);
           }
           generate(arr, k-1);
       }

    }
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        generate(arr, arr.length);
    }
}
