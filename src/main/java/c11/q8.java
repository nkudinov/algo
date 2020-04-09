package c11;

import java.util.NavigableSet;
import java.util.TreeMap;

public class q8 {
    static class Ranker {
        static TreeMap<Integer,Integer> map = new TreeMap<>();
        public void track(int x) {
            Integer v = map.get(x);
            map.put(x , v ==null?1:v+1);
        }
        public int getRank(int x){
            int ret = 0;
            for(Integer k:map.navigableKeySet()){
               if (k < x)
                   ret++;
            }
            return ret;
        }
    }
    public static void main(String[] args) {
        Ranker r = new Ranker();
        r.track(1);
        r.track(0);
        r.track(3);
        System.out.println(r.getRank(1));
        System.out.println(r.getRank(0));
        System.out.println(r.getRank(3));
    }

}
