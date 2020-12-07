package g;

import java.util.Arrays;

public class q16 {
        public static int[] maxArray(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[k];
            for (int i = 0, j = 0; i < n; ++i) {
                while (n - i + j > k && j > 0 && ans[j - 1] < nums[i])
                    j--;
                if (j < k)
                    ans[j++] = nums[i];
            }
            return ans;
        }

        public static void main(String[] args) {
            int[] arr = new int[] {2,4,5,7,1};
            System.out.println(Arrays.toString(maxArray(arr,2)));
        }
}
