package topk;
import java.util.*;
public class topK1<T> {
    public  Map<T,Integer> consume(Iterator<T> iter, int k){
        Map<T, Integer> freq = new HashMap<>();
        while(iter.hasNext()) {
            T x = iter.next();
            if (freq.containsKey(x)){
                freq.merge(x , 1, (a,b) -> a + b);
            } else if (freq.size() <= k-1){
                freq.put(x, 1);
            } else {
                Set<T> deleteSet = new HashSet<>();
                for(T key: freq.keySet()){
                    if (freq.get(key) == 1){
                        deleteSet.add(key);
                    } else {
                        freq.merge(key, -1, (a,b) -> a +b);
                    }
                }
                for(T key:deleteSet){
                    freq.remove(key);
                }
            }
        }
        return freq;
    }
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,30);
        map.put(2,20);
        map.put(3,3);
        MapRandomIterator<Integer> iter = new MapRandomIterator<>(map);
        topK1<Integer> topK = new topK1<>();
        System.out.println( topK.consume(iter, 2));
    }
}
