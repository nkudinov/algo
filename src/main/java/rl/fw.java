package rl;

import java.util.HashMap;
import java.util.Map;

public class fw {
    int limit;
    Map<String,Integer> map;
    fw(int n){
       this.limit = n;
       this.map = new HashMap();
    }
    public boolean offer(String cliecntID){
        long key = System.nanoTime()/1_000_000_000_000L;
        System.out.println(key);
        System.out.println();
        map.putIfAbsent(cliecntID+"."+key, limit);

        return true;
    }
    public static void main(String[] args) {
      fw rl = new fw(10);
      rl.offer("test");
    }
}
