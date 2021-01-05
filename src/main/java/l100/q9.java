package l100;

import java.util.*;

public class q9 {

    public static void helper(int[] candidates, int index, int target, Set<List<Integer>> acc, String curr){
        if (index == candidates.length){
            System.out.println(curr);
            if (target == 0){

                List<Integer> lst = new ArrayList<>();
                for(String s:curr.split("-")){
                    if (s.length()!=0)
                        lst.add(Integer.parseInt(s));
                }
                acc.add(lst);
            }
        } else {
            int x = candidates[index];
     //       if (target - x >= 0){
               helper(candidates,  index + 1, target - x , acc, curr+"-"+x);
    //        }
            helper(candidates,  index + 1, target, acc, curr);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, set, "");
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
       int[] arr = new int[]{2,5,2,1,2};
       //2,5,2,1,2
       for(List<Integer> lst:combinationSum2(arr ,5)){
           System.out.println(lst);
       }
    }
}
