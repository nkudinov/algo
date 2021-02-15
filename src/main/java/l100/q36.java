package l100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class q36 {

    public static int smallestDistancePair2(int[] nums, int k) {
        int N = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b-a);
        for(int i = 0; i < N; i++){
            for(int j = i+1; j<N;j++){
                    pq.add(Math.abs(nums[j]-nums[i]));
                    if (pq.size() > k){
                        pq.poll();
                    }
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1,6,1};
        System.out.println(smallestDistancePair2(arr,3));
    }
}
