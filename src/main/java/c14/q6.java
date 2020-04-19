package c14;

import org.jetbrains.annotations.NotNull;

import java.util.Deque;
import java.util.Iterator;

public class q6 {
 static class CircularArray<T> implements Iterable<T> {

     private Object[] arr;
     private int start;
     private int end;
     private int n;

     public CircularArray(int n) {
         this.arr = new Object[n];
         this.start = -1;
         this.end = 0;
         this.n = n;
     }

     public T takeFirst() {
         int indx = start;
         start = (start + 1) % n;
         return (T) arr[indx];
     }

     public T takeLast() {
         int indx = end;
         if (end == 0) {
             end = n - 1;
         } else if (start == end) {
             start = -1;
             end = 0;
         } else {
             end = (end - 1);
         }
         return (T) arr[indx];
     }

     public void addFirst(T t) {
         arr[--start] = t;
     }

     public void addLast(T t) {
         if (start == -1) {
             start = 0;
             arr[start] = t;
         } else if (start == end) {
             throw new IllegalStateException("can not add more element");
         } else {
             arr[end] = t;
         }
         end = (end + 1) % n;
     }

     public int getSize() {
         if (start == -1)
             return 0;
          else if (start < end )
             return end - start;
          else if (start == end)
             return n;
          else
             return (n - start) + end;

     }

     @NotNull
     @Override
     public Iterator<T> iterator() {
         return new Iterator<T>() {
             int curr = start;
             int cnt  = getSize();
             @Override
             public boolean hasNext() {
                 return cnt > 0;
             }

             @Override
             public T next() {
                  cnt--;
                  int indx = curr;
                  curr = (curr+1) % n ;
                  return (T) arr[indx];
             }
         };
     }
 }

    public static void main(String[] args) {
        CircularArray<Integer> arr = new CircularArray<>(3);
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.takeFirst();
        arr.addLast(4);
        arr.takeLast();
        arr.takeLast();
        arr.addLast(1);
      //  arr.takeLast();
        for(Integer i:arr){
            System.out.println(i);
        }
    }
}
