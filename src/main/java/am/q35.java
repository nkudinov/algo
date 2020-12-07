package am;

import java.util.Arrays;

public class q35 {
    public static int minDifficulty(int[] jobDifficulty, int d) {
        System.out.println(Arrays.toString(jobDifficulty));
        int n = jobDifficulty.length;
        if(n < d)
            return -1;
        int[][] dp = new int[d][n];

        dp[0][0] = jobDifficulty[0];
        for(int i = 1; i < n; i++){
            dp[0][i] = Math.max( jobDifficulty[i],dp[0][i-1]);
        }
        System.out.println(Arrays.toString( dp[0]));
        for(int i = 1; i < d; i++){
            for(int j = i; j < n; j++){
                int localMax = jobDifficulty[j];
                dp[i][j] = Integer.MAX_VALUE;
                for(int r = j; r >= i; r--){
                    localMax = Math.max(localMax,jobDifficulty[r]);
                    dp[i][j] =  Math.min(dp[i][j],dp[i-1][r-1] + localMax);
                }
            }
        }

        return dp[d-1][n-1];
    }
    public static void main(String[] args) {
      int[] arr = new int[]{5,6,4,3,2,1};
      System.out.println(minDifficulty( arr,2));
    }


}
