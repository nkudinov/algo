package f;

import scala.Int;

import java.util.LinkedHashMap;
import java.util.Map;

public class q48 {


    public static void main(String[] args) {
        Map<Integer,Integer> cache = new LinkedHashMap<>(1,1,true);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);    // evicts key 2
        cache.put(3, 3);    // evicts key 2
        for(Integer e:cache.keySet()){
            System.out.println(e);
        }
    }
}
