package m;

import java.util.Arrays;

public class q2 {
    private static int helper(int[] A, int i){
        if (i >= A.length ){
            return 0;
        }
        int curr = A[i];
        int next = 0;
        if (i == A.length -1){
            next = A[0];
        } else {
            next = A[i+1];
        }
        if ( (next + curr) %2 == 1){
            return helper(A, i + 1);
        }
        return Math.max( 1 + helper(A, i+2), helper(A,i+1));
    }
    public static int solution(int[] A) {
        int[] memo = new int[A.length];
        Arrays.fill(memo, -1);
        return helper(A, 0);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,5,8,7,3,7};
        System.out.println(solution(arr));

        arr = new int[]{14,21,16,35,22};
        System.out.println(solution(arr));

        arr = new int[]{5,5,5,5,5,5};
        System.out.println(solution(arr));
    }
}
