package lc.July2020;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class d31 {

    static Map<Integer,Integer> m = new HashMap<>();

    public static int climbStairs(int n) {
        if (m.containsKey(n)){
            return m.get(n);
        }
        if ( n == 0 ){
            return 1;
        } else if ( n < 0){
            return 0;
        }
        m.put(n,climbStairs(n-1)+climbStairs(n-2));
        return m.get(n);
    }
    public static void main(String[] args) {
        System.out.println( climbStairs(44));
    }
}
