package lc.june2020;

public class q10 {
    static public int searchInsert( int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        int mid = 0;

        while(begin <= end){
          mid = begin + (end-begin)/2;
          int val = nums[mid];
          if ( val > target){
              end = mid - 1;
          } else if (val < target){
              begin = mid +1;
          } else {
              return mid;
          }
        }
        return begin;

    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
    }
}
