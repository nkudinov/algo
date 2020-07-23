package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Merger {
    PriorityQueue<LongArray> q;
    static class LongArray{
        private long[] arr;
        private int pos;
        LongArray(long[] arr){
            this.arr = Arrays.copyOf(arr, arr.length);
            Arrays.sort(this.arr);
            pos = 0;
        }
        public Long getCurent(){
            return arr[pos];
        }
        public boolean load(){
            if (pos < arr.length-1){
                pos++;
                return true;
            }
            return false;
        }
    }
    Merger(){
        Comparator<LongArray> cmp = new Comparator<LongArray>() {
            @Override
            public int compare(LongArray o1, LongArray o2) {
                return o1.getCurent().compareTo(o2.getCurent());
            }
        };
        q = new PriorityQueue<>(cmp);
    }
    public void add(LongArray arr){
        q.add(arr);
    }
    public long next(){
       if (!q.isEmpty()) {
           LongArray arr = q.poll();
           long ret = arr.getCurent();
           if (arr.load()) {
               q.add(arr);
           }
           ;
           return ret;
       }
       return -1;
    }
    public static void main(String[] args) {
        Merger m = new Merger();
        LongArray a1 = new LongArray(new long[]{100,2,3,0});
        LongArray a2 = new LongArray(new long[]{1,2,3,100,200});
        m.add(a1);
        m.add(a2);
        long next = m.next();
        while(next!=-1){
            System.out.println(next);
            next = m.next();
        }
    }
}
