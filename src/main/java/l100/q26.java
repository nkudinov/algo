package l100;

public class q26 {
    public static int helper(int[] A, int K, int index, int min, int max){
        if (index == A.length){
            return max-min;
        }
        int x = A[index];
        int m = helper(A, K, index+1, Math.min(min, x-K), Math.max(max, x-K));
        int p = helper(A, K, index+1, Math.min(min, x+K), Math.max(max, x+K));
        return Math.min( m, p);

    }
    public static int smallestRangeII(int[] A, int K) {
        return helper(A,K, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(smallestRangeII( arr, 0));
    }
}
