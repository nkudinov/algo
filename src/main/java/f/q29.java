package f;

import scala.Array;
import scala.Int;

import java.util.*;

public class q29 {
    // 1,2,3,4,7,6,5,3,2
    public  static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length-1;
        while(i < j){
          swap(nums, i, j);
          i++;
          j--;
        }
    }
    public static void nextPermutation(int[] nums) {
       int i = nums.length-2;
       while (i>=0 && nums[i+1] <= nums[i]){
           i--;
       }
       if (i !=0 ){
           int j = nums.length-1;
           while(j >=0 && nums[j] <= nums[i]){
               j--;
           }
           swap(nums,i,j);
       }
       reverse(nums, i +1);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,5};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

}
