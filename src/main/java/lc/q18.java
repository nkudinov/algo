package lc;

import java.util.Arrays;

public class q18 {
    static public int removeDuplicates(int[] nums) {
       int i = 0;
       for(int j = 1; j < nums.length; j++){
           if (nums[j] != nums[i]){
               i++;
               nums[i] = nums[j];
           }
       }
       //0
       //0,1,2,3,4,2,1,2,2,3,3,4
       //
       System.out.println(Arrays.toString(nums));
       return i+1;
    }
    public static void main(String[] args) {
     int arr [] = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }

}
