package lc;

import java.util.*;

public class q30 {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3};
        Set<List<Integer>> prev = new LinkedHashSet<>();
        prev.add(new ArrayList<>());
        Set<List<Integer>> curr;

        for(int x:arr){
             curr = new HashSet<>();
             for(List<Integer> lst:prev){
                 List<Integer> tmp = new ArrayList<>(lst);
                 tmp.add(x);
                 curr.add(lst);
                 curr.add(tmp);
             }
             prev = curr;
        }
        for(List<Integer> lst: prev){
            System.out.println(lst);
        }

    }
}
