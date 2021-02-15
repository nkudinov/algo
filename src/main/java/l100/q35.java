package l100;

import java.util.HashMap;
import java.util.Map;

public class q35 {
    public static int helper(int[] nums, int i, Map<Integer,Integer> memo){
        System.out.println(i);
        if (i <0){
            return 0;
        }
        if (memo.containsKey(i)){
            return memo.get(i);
        }
        int a = helper(nums, i-2, memo) + nums[i];
        int b = helper(nums, i-1, memo);
        memo.put(i, Math.max( a, b));

        return memo.get(i);
    }
    public static int rob(int[] nums) {
        Map<Integer,Integer> memo = new HashMap<>();
        return helper(nums, nums.length-1 , memo);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(rob(arr));
    }

}
