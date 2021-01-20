package l100;

public class q17 {
    public static int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        return helper(K, N, memo);
    }
    private static int helper(int K, int N, int[][] memo) {
        if (N == 1) {
            return N;
        }
        if (K == 1) {
            return N;
        }
        if (memo[K][N] > 0) {
            return memo[K][N];
        }
        int min = N;
        for (int i = 1; i <= N; i++) {
            int left = helper(K - 1, i - 1, memo);
            int right = helper(K, N - i, memo);
            min = Math.min(min, Math.max( left, right) + 1);
        }
        memo[K][N] = min;
        return min;
    }


    public static void main(String[] args) {
        System.out.println(superEggDrop(2,100));
    }
}
