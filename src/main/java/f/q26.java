package f;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q26 {
    static int[] findMaxProduct(int[] arr) {
        // Write your code here
        int[] ret = new int[arr.length];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i< arr.length; i++){
            heap.add(arr[i]);
            if (heap.size() > 3){
                heap.poll();
            }
            if (heap.size() < 3){
                ret[i] = -1;
            } else {
                Integer[] tmp = heap.toArray(new Integer[3]);
                ret[i] =  tmp[0] * tmp[1]*tmp[2];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(findMaxProduct(arr)));
    }
}
