package f;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q27 {
    static int[] findMedian(int[] arr) {
        // Write your code here
        int[] ret = new int[arr.length];
        int[] tmp = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if (i == 0){
                tmp[0] = arr[0];
                ret[0] = arr[i];
            } else {
                tmp[i] = arr[i];

                int j = i-1;
                int k = i;

                while(j >= 0 && tmp[j] > tmp[k]){
                    int value = tmp[j];
                    tmp[j] = tmp[k];
                    tmp[k] = value;
                    j--;
                    k--;
                }
               // System.out.println(Arrays.toString(tmp));
                int n = i+1;
                if ( i % 2 == 1){
                    ret[i] = (tmp[n/2-1]+tmp[n/2])/2;
                } else {
                    ret[i] = tmp[n/2];
                }
            }

        }
        return ret;
    }
    public static void main(String[] args) {
        //5, 15, 1, 3
        // 1 5 15
        System.out.println(Arrays.toString(findMedian(new int[]{5, 15, 1, 3})));
    }

}
