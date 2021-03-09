package l100;

import java.util.*;

public class q56 {
    public static void helper(int [] arr, Set<List<Integer>> acc, List<Integer> curr){
        if (arr.length == curr.size()){
            int prev = curr.get(0);
            for(int i  = 1; i < arr.length; i++){
               if (Math.sqrt( prev+curr.get(i)) % 1 != 0.0){
                   return;
               }
               prev = curr.get(i);
            }
            acc.add(new ArrayList<>(curr));
        } else {
            int N = arr.length;
            for(int i = 0; i < N ; i++){

                curr.add(arr[i]);
                helper(arr, acc, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public static int numSquarefulPerms(int[] arr) {
        Set<List<Integer>> acc = new HashSet<>();
        Arrays.sort(arr);
        helper(arr, acc, new ArrayList<>());
        return acc.size();
    }
    public static void main(String[] args) {
        int[] arr =  new int[]{2,2,2};
        //1,8,17
        System.out.println(numSquarefulPerms(arr));
    }
}
