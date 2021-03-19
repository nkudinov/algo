package l100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q59 {
    static void helper(int[] arr, List<Integer> curr, Set<Integer> seen, List<List<Integer>> acc){
        if (curr.size() == arr.length ){
            acc.add(new ArrayList<>(curr));
        } else {
           for( int i = 0; i < arr.length; i++){
               if ( !seen.contains(i)){
                   seen.add(i);
                   curr.add(arr[i]);
                   helper( arr, curr, seen, acc);
                   seen.remove((Integer)i);
                   curr.remove(curr.size()-1);
               }
           }
        }
    }
    static List<List<Integer>>  perm(int[] arr){
        List<List<Integer>> acc= new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        helper( arr, curr, seen, acc);
        return acc;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {1,2,3};
        for(List<Integer> lst:perm(arr)){
            System.out.println(lst);
        }
    }
}
