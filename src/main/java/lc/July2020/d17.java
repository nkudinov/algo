package lc.July2020;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class d17 {
    private static boolean replaceMin(int[] buf, int val){
        int index =0;
        for(int i =0; i < buf.length;i++){
           if (buf[index] > buf[i]){
               index = i;
           }
        }
        if (buf[index]!=val){
            buf[index] = val;
            return true;
        }
        return false;
    }
    public static int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> m = new HashMap<>();
       for(int i =0;i<nums.length;i++){
          m.merge( nums[i],1, (a,b) -> a+b);
       }
       int[] ret = new int[k];
       int i = 0;
       List<Integer>  l = m.entrySet()
         .stream()
         .sorted( Map.Entry.<Integer, Integer>comparingByValue().reversed())
         .limit(k).map(x -> x.getKey()).collect(Collectors.toList());

       for(Integer e:l){
           ret[i++] = e;
       }

       return ret;
    }
    public static void main(String[] args) {
      int[] arr = new int[]{1,1,1,2,2,3};
      System.out.println(Arrays.toString(topKFrequent(arr,2)));
    }
}
