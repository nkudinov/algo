package dp;

import java.util.Arrays;

public class q1 {
    public static int f(int[] arr){
       int N  = arr.length;
       int[] dp = new int[N];
       for(int i = 0 ; i < N; i++){
           if (i <= 1){
               dp[i] = arr[i];
           } else {
               dp[i] = Math.max( dp[i-1], dp[i-2]+arr[i]);
           }
       }
       System.out.println(Arrays.toString(dp));
       return dp[N-1];
    }
    public static void main(String[] args) {
        int [] arr = new int[]{3,10,3,1,2};
        //[3, 10,  3,  1,  2]
        //[3, 10, 10, 11, 12]
        System.out.println(f(arr));

    }
}
