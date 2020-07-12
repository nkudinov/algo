package lc.July2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class d11 {
    public static List<Integer> generateList(int x, int[] nums){
       List<Integer> ret = new ArrayList<>();
       for(int j = 0; j < nums.length;j++){
           if ( ((x >> j) & 1)==1){
               ret.add(nums[j]);
           }
       }
       return ret;
    }
    static public List<List<Integer>> subsets(int[] nums) {
       Set<List<Integer>> ret = new HashSet<>();
       int n = (int)Math.pow(2,nums.length);
       for(int i=0;i<=n;i++){
           ret.add(generateList(i,nums));
       }
       return new ArrayList<>(ret);
    }
    public static void main(String[] args) {
       int[] arr = new int[] {1,2,3};
       for(List<Integer> list:subsets(arr)){
           System.out.println(list);
       }
    }
}
