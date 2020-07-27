package f;

import scala.Int;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q3 {
     static  int numberOfWays(int[] arr, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int e:arr){
            m.merge(e,1, (a,b) -> a+b);
        }
        int ret = 0;
        for(int e:arr){
            int r = k - e;
            ret += m.getOrDefault(r,0);
            if (e == r){
                ret--;
            }
        }
        return ret/2;
     }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 3 , 4};
        System.out.println(numberOfWays(arr,6));

        arr = new int[] {1, 3, 3, 3, 5};
        System.out.println(numberOfWays(arr,6));

    }
}
