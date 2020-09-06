package g;

import java.util.Arrays;
import java.util.Collection;

public class q4 {
    static public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // partition by zero element
    static public int partition( int[] nums, int l, int r){
        // 5, 4, 8, 0,2,6
        // 5, 8, 10, 1

        int pivotIndex = l;
        for( int i = l; i <= r;i++){
           if (nums[i]  <  nums[l]) {
                pivotIndex++;
                swap(nums, i, pivotIndex);
            }
        }
        swap(nums, l , pivotIndex);
        return pivotIndex;
    }
    static public int findKthLargest( int[] nums, int k) {
        int l = 0;
        int r = nums.length-1;
        int K = nums.length-k;
        while( l <= r ){
            System.out.println(Arrays.toString(nums)+" l = " + l +" r = " + r);
            int pivotIndex = partition(nums, l, r);
            if (pivotIndex < K ){
               l = pivotIndex +1;
            } else if (pivotIndex > K){
               r = pivotIndex -1;
            } else {
               return nums[pivotIndex];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
//[3,2,1,5,6,4]
//        2
        System.out.println(findKthLargest(arr,2));
        System.out.println(Arrays.toString(arr));
    }

}
