package f;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class q21 {
    static int minOverallAwkwardness(int[] arr) {
        Arrays.sort(arr);
        Deque<Integer> dq = new LinkedList<>();
        dq.add(arr[0]);
        int maxDelta  = 0;
        for( int i = 1; i < arr.length; i++){
          int prev;
          int curr = arr[i];
          if ( i%2 == 0){
            prev = dq.peekLast();
            dq.addLast(curr);
          } else {
              prev = dq.peekFirst();
              dq.addFirst(curr);
          }
          if (  Math.abs(curr-prev)  > maxDelta){
              maxDelta =  Math.abs(curr-prev);
          }
        }
        return maxDelta;
    }
    public static void main(String[] args) {
        System.out.println(minOverallAwkwardness(new int[]{5, 10, 6, 8}));
    }

}
