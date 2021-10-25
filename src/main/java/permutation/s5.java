package permutation;

import java.util.ArrayList;
import java.util.List;

public class s5 {
    public static List<List<Character>> subsets(char[] arr){
       List<List<Character>> ans = new ArrayList<>();
       helper(arr, 0, new ArrayList<>(), ans);
       return ans;
    }
    private static void helper(char[] arr, int start, List<Character> curr, List<List<Character>> acc ){
        acc.add(new ArrayList<>(curr));
        System.out.println(acc);
        for(int i = start;  i < arr.length; i++){
            curr.add(arr[i]);
            helper(arr, i + 1, curr, acc);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        char[] arr = new char[]{'A','B','C'};
        for(List<Character> lst:subsets(arr)){
            System.out.println(lst);
        }
    }
}
