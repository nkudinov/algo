package f;

import scala.Int;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class q47 {
    static class Entry {
        int value;
        int time;

        public Entry(int value,int time) {
            this.value = value;
            this.time = time;
        }
    }

   static public class LRUCache {
       Map<Integer, Entry> map;
       int capacity;
       int time;
       public LRUCache(int capacity) {
           this.capacity = capacity;
           this.map = new HashMap<>(this.capacity);
           time = 0;
       }

       public int get(int key) {
          if (  map.containsKey(key)) {
               Entry e = map.get(key);
               put(key,e.value);
               return map.get(key).value;
           }
           return -1;
       }

       public void put(int key, int value) {
           time++;
           if (!map.containsKey(key) && map.size() == capacity) {
               int k = -1;
               int t = Integer.MAX_VALUE;
               for (Map.Entry<Integer, Entry> e : map.entrySet()) {
                   if (e.getValue().time < t) {
                       k = e.getKey();
                       t = e.getValue().time;
                   }
               }
               map.remove(k);
           }
           if (map.containsKey(key)) {
               Entry entry = map.get(key);
               entry.value = value;
               entry.time  = time;
               map.put(key, entry);
           } else {
               map.put(key, new Entry(value, time));
           }
       }
   }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
