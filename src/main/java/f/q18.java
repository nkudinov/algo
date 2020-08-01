package f;

import java.util.Arrays;
import java.util.Collections;

public class q18 {
    static int getTotalTime(int[] arr) {
        int[] ret = Arrays.copyOf(arr,arr.length);
        Arrays.sort(ret);
        int penalty = 0;
        while(ret.length!=1){
            int[] temp = new int[ret.length-1];
            for(int i =  0 ; i < temp.length ; i++){
                if (i == temp.length-1){
                    temp[temp.length-1] = ret[ret.length-1]+ret[ret.length-2];
                }else {
                    temp[i] = ret[i];
                }
            }
            ret = temp;
            penalty += ret[ret.length-1];
        }
        return penalty;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 1, 3};
        System.out.println(getTotalTime(arr));
    }

}
