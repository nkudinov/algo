package l100;

public class q68 {
    public static int numberOfArithmeticSlices(int[] nums) {
        int N = nums.length;
        int ans = 0;
        for(int i = 0; i <= N - 3; i++){
            int diff = nums[i+1]-nums[i];
            for(int j = i+2; j < N; j++){
                if ( nums[j] - nums[j-1] != diff){
                    break;
                } else if ( j - i >= 2) {
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
       int[] arr = new int[]{1,2,3,4};
        System.out.println(numberOfArithmeticSlices(arr));
    }

}
