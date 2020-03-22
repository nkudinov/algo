package w2;

import scala.reflect.internal.util.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1 {
    static List<Integer> change(int s, int[] arr){
       List<Integer> ret = new ArrayList<>();
       for(int a:arr){
         int x = s/a;
         s = s -x*a;
         ret.add(x);
       }
       return ret;
    }
    public static void main(String[] args) {
        System.out.println(change(26, new int[]{10, 5, 2, 1}));
        System.out.println(change(19, new int[]{5, 3, 2}));
        System.out.println(change(21, new int[]{4, 2, 1}));
        System.out.println(change(27, new int[]{10, 8, 2, 1}));
    }
}
