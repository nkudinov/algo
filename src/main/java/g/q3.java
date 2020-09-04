package g;

import java.util.PriorityQueue;

public class q3 {

    static public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int e:nums){
            heap.add(e);
            if (heap.size() > k){
                heap.poll();
            }
        }
        return heap.poll();
    }
    public static void main(String[] args) {
       int value = findKthLargest(new int[]{1,2,3,4,5},2);
       System.out.println(value);

    }
}
