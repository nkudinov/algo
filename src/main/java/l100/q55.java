package l100;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q55 {
    static void helper( int[] arr, int start, List<List<Integer>> acc, List<Integer> curr){
       acc.add( new ArrayList<>(curr));
       {
           int N = arr.length;
           for (int i = start; i < N; i++ ) {
              // if(curr.contains(arr[i])) continue;
                curr.add(arr[i]);
                helper( arr, i +1, acc, curr);
                curr.remove(curr.size() - 1);
           }
       }
    }
    static  List<List<Integer>> perm(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        helper( arr,0, ans , new ArrayList<Integer>());
        return  ans;
    }
    public static void main(String[] args) {
       int[] arr = new int[] {1,2,3,4,5};
       for(List<Integer> lst:perm(arr)){
           System.out.println(lst);
       }
    }


}
