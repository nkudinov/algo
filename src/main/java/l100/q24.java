package l100;

public class q24 {
    public static int findLongestChain(int[][] pairs) {
        int N = pairs.length;
        int[] dp = new int[N];
        int ans = 0;
        for(int i = 0; i < N; i++){
            int maxLen = 0;
            //[[1,2], [2,3], [3,4]]
            int c = pairs[i][1];
            int d = pairs[i][1];
            for(int j = 0; j < i; j++){
                int a = pairs[j][0];
                int b = pairs[j][0];
                if ( b < c){
                    maxLen = Math.max( maxLen, dp[j]);
                }
            }
            dp[i] = maxLen+1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public static void main(String[] args) {

    }

}
