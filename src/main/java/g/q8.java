package g;

import java.util.Arrays;

public class q8 {
    static public int[] searchRange(int[] nums, int target) {

         int l = 0;
         int r = nums.length-1;
         while(l <= r ){
             int m = l + ( r-l)/2;
             if (nums[m] > target){
                 r = m -1;
             } else if (nums[m] < target){
                 l = m +1;
             } else {
                int left  = m;
                int right = m;
                while(left >= 0 && nums[left] == target){
                     left--;
                }
                 while(right<nums.length && nums[right] == target){
                     right++;
                 }
                 return new int[]{left+1, right-1};
             }
         }
         return new int[]{-1,-1};
    }
    public static void main(String[] args) {
       int[] arr = new int[]{1};
        System.out.println(Arrays.toString(searchRange(arr, 1)));
    }
}
