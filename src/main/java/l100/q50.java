package l100;

import java.util.ArrayList;
import java.util.List;

public class q50 {

    private static List<List<Integer>> ans;
    private static int[] nums;

    public static List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        q50.nums = nums;

        backtrack(0, new ArrayList<>());
        return ans;
    }

    private static void backtrack(int i, List<Integer> builder) {
        ans.add(new ArrayList<>(builder));
        System.out.println("added to result: "+ans.get(ans.size()-1));
        for (int j = i; j < nums.length; j++) {
            builder.add(nums[j]);
            System.out.println("after ADD:"+ builder);
            backtrack(j + 1, builder);
            builder.remove(builder.size() - 1);
            System.out.println("after remove:"+ builder);
        }
    }

    public static void main(String[] args) {
        int count = subsets(new int[]{1,2,3,4}).size();
        System.out.println(count);
    }
}

