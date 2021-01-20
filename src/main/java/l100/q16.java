package l100;

import java.util.concurrent.atomic.AtomicInteger;

public class q16 {
    public void helper(int[][] A, int r, int c, int curr,  AtomicInteger sum){
        if (r == A.length ){
            if (sum.get() > curr){
                sum.set(curr);
            }
            return;
        }
        for(int col = 0; col < A.length; col++){
            if (r == 0 || col == c || col == c - 1 || col == c + 1 ){
                helper( A, r + 1, col, curr + A[r][col], sum);
            }
        }
    }
    public int minFallingPathSum(int[][] A) {
        AtomicInteger sum = new AtomicInteger( Integer.MAX_VALUE);
        helper( A, 0, -1, 0, sum);
        return sum.get();
    }
    public static void main(String[] args) {

    }
}
