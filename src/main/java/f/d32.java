package f;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class d32 {
    public static void insert(List<Integer> curr, int j, int value){
        curr.add(j, value);
    }
    public static void helper(int[] nums, Set<List<Integer>> lst, int i, List<Integer> curr){
        if (curr.size() == nums.length){
            lst.add(curr);
        } else {
            int x = nums[i];
            for(int j = 0; j <= curr.size(); j++){
                List<Integer> newList = new ArrayList<>();
                newList.addAll(curr);
                insert(newList, j, x);
                helper(nums, lst, i+1,  newList);
            }
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        helper(nums, ret, 0,  new ArrayList<>());
        return new ArrayList<>(ret);
    }
    public static void main(String[] args) {
        Integer.valueOf(1).compareTo()
        for(List<Integer> l:permute(new int[]{1,2,3})){
            System.out.println(l);
        }
    }

}
