package lc.July2020;

import java.util.*;

public class d23 {
    static public int[] singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int e:nums){
            if (s.contains(e)){
                s.remove(e);
            }else{
                s.add(e);
            }
        }
        int[] ret = new int[2];
        int i = 0;
        for(Integer e:s){
            ret[i++] = e;
        }
        return ret;

    }
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,1,3,2,5};
        Integer.highestOneBit(diff);
        System.out.println(Arrays.toString(singleNumber(arr)));
    }

}
