package lc.june2020;

import java.util.Arrays;

public class q11 {
   static public void sortColors1(int[] nums) {
      int[] cnt = new int[]{0,0};
      for(int i=0;i<nums.length;i++){
         if (nums[i] < 2)
          cnt[nums[i]]++;
      }
      for(int i=0;i<nums.length;i++){
         if (cnt[0] > 0){
             nums[i] = 0;
             cnt[0]--;
         } else if (cnt[1] > 0){
             nums[i] = 1;
             cnt[1]--;
         } else {
             nums[i] = 2;
         }
      }
    }
    static public void sortColors2(int[] nums) {
        int i = 0;
        int j = nums.length;
        while ( i<=j ){

        }

    }
    public static void main(String[] args) {
        int[] arr = new int [] {2,0,2,1,1,0};
        sortColors2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
