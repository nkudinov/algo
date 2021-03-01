package l100;

import java.util.ArrayList;
import java.util.List;

public class q52 {
    static  class Solution {
        List<List<Integer>> output = new ArrayList();
        int n, k;

        public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
            // if the combination is done
            if (curr.size() == k) {
                output.add(new ArrayList(curr));
                return;
            }
            for (int i = first; i < n; ++i) {
                // add i into the current combination
                curr.add(nums[i]);
                // use next integers to complete the combination
                backtrack(i + 1, curr, nums);
                // backtrack
                curr.remove(curr.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            n = nums.length;
            for (k = 0; k < n + 1; ++k) {
                backtrack(0, new ArrayList<Integer>(), nums);
            }
            return output;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for(List<Integer> lst: s.subsets(new int[]{1,2,3})){
            System.out.println(lst);
        }
    }
}
