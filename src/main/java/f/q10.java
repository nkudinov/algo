package f;

import java.util.Arrays;

public class q10 {
    static int search(int[] arr, int value){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            int mid_value = arr[mid];
            if (mid_value == value){
                return mid;
            } else if (value > mid_value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left < arr.length && arr[left] > value){
            return left;
        }
        return -1;
    }
    static int[] getMilestoneDays(int[] revenues, int[] milestones) {

       int[] total = new int[revenues.length];
       for(int i = 0; i < total.length;i++ ){
           total[i] = revenues[i];
           if (i!=0){
               total[i] += total[i-1];
           }
       }
       int[] ret = new int[milestones.length];
       for(int i = 0 ; i < ret.length; i++){
           int index = search( total, milestones[i]);
            ret[i] = index+1;
       }
       return ret;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{100, 200, 300, 400, 500};
        int[] milestones = new int[]{ 300, 800, 1000, 1400};
        System.out.println(search(new int[]{ 100, 300, 600, 1000, 1500},1600));
       // System.out.println(Arrays.toString(getMilestoneDays( arr, milestones)));
        //300, 800, 1000, 1400
    }
}
