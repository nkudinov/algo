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
        //5,6
        for(int e:heap){
            System.out.println("e="+e);
        }
        return heap.poll();
    }
    public static void main(String[] args) {
        //[3,2,1,5,6,4]
        //2
       int value = findKthLargest(new int[]{3,2,1,5,6,4},2);
       System.out.println(value);

    }
}
