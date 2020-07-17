package sort;

import java.util.Arrays;

public class Radix {
    static void countSort(int[] arr, int exp) {
         int n = arr.length;
         int[] count = new int[10];
         int[] output = new int[arr.length];

         for(int i=0;i<n;i++){
             count[(arr[i]/exp)%10]++;
         }
         for(int i=1;i<count.length;i++){
             count[i] += count[i-1];
         }
         for( int i = n-1; i >= 0; i--){
             output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
             count[ (arr[i]/exp)%10 ]--;
         }
         for (int i = 0; i < n; i++)
             arr[i] = output[i];
    }
    static void sort(int[] arr){
        int m = Arrays.stream(arr).max().getAsInt();
        for(int exp = 1; m/exp > 0; exp *= 10){
            countSort(arr, exp);
        }
    }
    public static void main(String[] args) {
       int[] arr = new int[]{101,2,1,803};
       sort(arr);
       System.out.println(Arrays.toString(arr));
    }
}
