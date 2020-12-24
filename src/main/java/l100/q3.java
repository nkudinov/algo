package l100;

import java.util.Arrays;
import java.util.Stack;

public class q3 {
    static int maxAreaByHistogram(int[] histogram){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxArea = 0;
        int N = histogram.length;

        for(int i = 0; i < N; i++){
            while(stack.peek() != -1 && histogram[stack.peek()] > histogram[i]){
                int h = histogram[stack.pop()];
                int w = (i - stack.peek()-1);
                maxArea = Math.max(maxArea, h*w);
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            int h = histogram[stack.pop()];
            int w = (N - stack.peek()-1);
            maxArea = Math.max( maxArea, h*w);
        }
        return maxArea;
    }
    public static int maximalRectangle(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int[] dp = new int[COLS];
        int ans  = 0;
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0 ; c < COLS; c++) {
                dp[c] = matrix[r][c] == 0?0:dp[c]+1;
            }
            System.out.println(Arrays.toString(dp));
            ans = Math.max( ans, maxAreaByHistogram(dp));
        }
        return ans;
    }
    public static void main(String[] args) {
      int[][] arr = new int[][]{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
      System.out.println(maximalRectangle(arr));
    }
}
