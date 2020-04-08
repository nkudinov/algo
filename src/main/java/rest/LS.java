package rest;

import java.util.ArrayList;
import java.util.List;

public class LS {
    public static List<Integer>  getLongest(List<Integer> l1, List<Integer> l2){
        if ( l1 == null ){
            return l2;
        } else if ( l2 == null ){
            return l1;
        } else {
           return l1.size() > l2.size()? new ArrayList<>(l1):new ArrayList<>(l2);
        }
    }
    public static List<Integer> lis(int[] arr){
       List<Integer>[] solutions = new ArrayList[arr.length];
       for(int i = 0; i < arr.length;i++){
           int value = arr[i];
           List<Integer> curr = new ArrayList<>();
           for(int j = 0; j < i; j++){
               if (arr[j] < value){
                   curr = getLongest( curr, solutions[j]);
               }
           }
           curr.add(value);
           solutions[i] = curr;
       }
       List<Integer> ret = new ArrayList<>();
       for(int i = 0; i < arr.length;i++) {
           System.out.println(solutions[i].toString());
           ret = getLongest( ret, solutions[i]);
       }
       return ret;
    }
    public static void main(String[] args) {
       int[] arr = { 3, 4, -1, 0, 6, 2, 3};
       System.out.println(lis(arr).toString());
    }
}
