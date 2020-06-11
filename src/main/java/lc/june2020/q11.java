package lc.june2020;

import java.util.Arrays;

public class q11 {
   static public void sortColors(int[] nums) {
      int[] cnt = new int[]{0,0,0};
      for(int i=0;i<nums.length;i++){
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

    public static void main(String[] args) {
        int[] arr = new int [] {2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
