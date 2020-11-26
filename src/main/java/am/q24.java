package am;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q24 {
    public static void prepare(Deque<Integer> deq, int[] nums, int i, int k){
        while( !deq.isEmpty() && deq.getFirst() <= i-k){
            deq.removeFirst();
        }
        while( !deq.isEmpty() && nums[deq.getLast()] <= nums[i]){
            deq.removeLast();
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        if ( n*k == 0){
            return new int[0];
        }
        Deque<Integer> deq = new ArrayDeque<>();
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < k ;i++){
            deq.addLast(i);
            maxValue = Math.max(maxValue, nums[i]);
        }
        ans[0] = maxValue;
        for( int i = k; i < n; i++){
            prepare(deq , nums, i, k);
            deq.addLast(i);
            ans[i-k+1] = nums[deq.getFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{ 1,-9,8,-6,6,4,0,5};
        System.out.println( Arrays.toString( maxSlidingWindow( arr,4)));
    }

}
