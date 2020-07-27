package f;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q4 {
    static boolean areTheyEqual(int[] array_a, int[] array_b) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int e:array_a){
            m.merge(e,1,(a,b)-> a+b);
        }
        for(int e:array_b){
            m.merge(e,-1,(a,b) -> a+b);
        }
        for( Map.Entry<Integer,Integer> e: m.entrySet()){
            if (e.getValue() !=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
      int[] a = new int[] {1, 2, 3, 4};
      int[] b = new int[] {1, 4, 3, 2};
      System.out.println(areTheyEqual(a,b));
    }
}
