package f;

public class q62 {
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while( l <= r){
            int m = l + (r-l)/2;
            if ( nums[m] == target){
                return m;
            } else if ( nums[l] <= nums[m] ) {
                if ( nums[l] <= target && target <= nums[m]){
                    r = m -1;
                } else {
                    l = m +1;
                }
            } else {
                if ( nums[m] <= target && target <= nums[r] ){
                    l = m +1;
                } else {
                    r = m -1;
                }
            }
        }
        return -1;
    }
    static public int minValueIndex(int[] arr){
        int l = 0;
        int r = arr.length-1;
        if (arr[l] < arr[r]){
            return l;
        }

        while ( l < r){
            int m = l + ( r -l)/2;
            int rV = arr[r];
            int mV = arr[m];
            if (mV < rV){
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        int[] arr  = new int[]{  3 ,4 ,5, 6, 7, 0, 1, 2 };
        int target = 3;
        System.out.println( search( arr, target));
    }

}
