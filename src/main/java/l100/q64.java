package l100;

import java.util.ArrayList;
import java.util.List;

public class q64 {
    static  void helper(char[] arr, List<Character> curr, List<String> acc){
        if (curr.size() == arr.length){
            acc.add(curr.toString());
            return;
        }
        for(int i = 0 ; i < arr.length; i++){
            if (!curr.contains(arr[i]))
                    curr.add(arr[i]);
            helper(arr,  curr, acc);
            if (curr.size() >=1 )
                curr.remove(curr.size()-1);
        }
    }
    static List<String> subsets(char[] arr){
       List<String> acc = new ArrayList<>();
       helper( arr, new ArrayList<>(), acc);
       return acc;
    };
    public static void main(String[] args) {
        char[] arr = new char[]{'a','b','c'};
        for(String set:subsets(arr)){
            System.out.println(set);
        }

    }

}
