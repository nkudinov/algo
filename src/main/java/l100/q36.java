package l100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class q36 {
    public static int smallestDistancePair1(int[] nums, int k) {
        int N = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            for(int j = i+1; j<N;j++){
                pq.add(Math.abs(nums[j]-nums[i]));
            }
        }

        for(int i = 1 ; i<k;i++){
            pq.poll();
        }
        return pq.peek();
    }
    public static int smallestDistancePair2(int[] nums, int k) {
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            for(int j = i+1; j<N;j++){
                int distance = Math.abs(nums[j]-nums[i]);
                if (!map.containsKey(distance)){
                    pq.add(distance);
                }
                map.merge(distance, 1, (a,b) -> a+b);
            }
        }
        while( k > 0){
            int e = pq.poll();
            int size = map.get(e);
            for(int i = 1; i <=size; i++){
                k--;
                if ( k == 0){
                    return e;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1,6,1};
        System.out.println(smallestDistancePair2(arr,3));
    }
}
