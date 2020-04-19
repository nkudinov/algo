package lc;

import java.util.*;

public class q16 {
    static public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++)
            map.put(nums[i], i);

        for(int i = 0 ; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = 0 - nums[i] - nums[j];
                if (map.containsKey(target) && map.get(target) > j) {
                    ret.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
        }
        return new ArrayList<>(ret);
    }
}
