package permutation;

import java.util.ArrayList;
import java.util.List;

public class s6 {
    static public void backtrack(int[] nums, int first, ArrayList<Integer> curr, int k, List<List<Integer>> acc) {
        if (curr.size() == k) {
            acc.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < nums.length; ++i) {
            curr.add(nums[i]);
            backtrack(nums, i + 1, curr, k, acc);
            curr.remove(curr.size() - 1);
        }
    }

    static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int k = 0; k <  nums.length + 1; ++k) {
            backtrack(nums,0, new ArrayList<>(), k , ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        for(List<Integer> lst:subsets(arr)){
            System.out.println(lst);
        }
    }
}
