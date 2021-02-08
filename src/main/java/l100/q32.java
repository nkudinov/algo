package l100;

public class q32 {
    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length;i++){
            if (nums[i-1] > nums[i]){
                cnt++;
                if( i-2 < 0 || nums[i-2] <= nums[i]) {
                     nums[i-1] = nums[i];
                } else {
                     nums[i] = nums[i-1];
                }
            }

        }
        return cnt<=1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,2,3};
        System.out.println(checkPossibility(arr));
    }

}
