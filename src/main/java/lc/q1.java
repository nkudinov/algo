package lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = {0,0};
        Map<Integer,Integer> m = new HashMap<>();
        for( int i=0; i < nums.length; i++){
            int value = nums[i];
            int delta = target - value;
            if (m.containsKey(delta)){
                return new int[]{m.get(delta),i};
            }else{
                m.put(value, i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
       int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr,9)));
    }
}
