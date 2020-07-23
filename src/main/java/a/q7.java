package a;

import java.lang.reflect.Array;
import java.util.Arrays;

public class q7 {
    static private void insert(int [] arr, int val){
        int index = 0;
        for(int i = 1; i< arr.length;i++){
            if ( arr[index] > arr[i]){
                index = i;
            }
        }
        arr[index] = val;
    }
    static public int[] topK(int[] arr, int k){
       int[] ret = new int[k];
       int i = 0;
       while(i < k && i < arr.length){
           ret[i] = arr[i];
           i++;
       }
       for(int j = k; j < arr.length;j++){
           insert(ret, arr[j]);
       }
       Arrays.sort(ret);
       return ret;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,4,5,11,10,0,99};
        System.out.println(Arrays.toString(topK(arr,3)));
    }
}
