package lc.aug2020;

import java.util.ArrayList;
import java.util.List;

public class d2 {
    static class MyHashSet {
        static List<Integer>[] arr;
        public MyHashSet() {
           arr  = new ArrayList[128];
           for(int i =0; i < arr.length;i++){
               arr[i] = new ArrayList<Integer>();
           }
        }

        public void add(int key) {
            if (contains(key)){
                return;
            }
            (arr[key%128]).add(key);
        }

        public void remove(int key) {
            if (!contains(key)){
                return;
            }
            List<Integer> list = arr[key%128];
                for(int i =0; i < list.size();i++){
                    if (list.get(i) == key){
                        list.remove(i);
                    }
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            for(Integer e: ((ArrayList<Integer>)arr[key%128])){
                  if (e == key){
                        return true;
                    }
                }
            return false;
        }
    }
    public static void main(String[] args) {
        MyHashSet h = new MyHashSet();
        h.add(1);
        h.remove(1);
        System.out.println(h.contains(1));
    }
}
