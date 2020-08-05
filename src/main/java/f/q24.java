package f;

import java.util.Arrays;

public class q24 {

    static int[] findSignatureCounts(int[] arr) {
       int[] ret = new int[arr.length];
       Arrays.fill(ret,1);
       for(int i = 0; i < arr.length;i++){
           int k = i;
           while (arr[k] != i + 1) {
               ret[i]++;
               k = arr[k] - 1;
           }
       }
       return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,5,1};
        System.out.println(Arrays.toString(findSignatureCounts(arr)));
    }
}
