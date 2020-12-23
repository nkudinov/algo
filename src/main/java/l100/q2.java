package l100;

import java.util.Stack;

public class q2 {
    public static int largestRectangleArea(int[] heights) {
        int ans = 0;
        for(int i = 0; i < heights.length ; i++){
            for(int j = 0; j <= i; j++){
                int maxH = Integer.MAX_VALUE;
                for(int k = j; k <=i; k++){
                    maxH = Math.min(maxH, heights[k]);
                }
                ans = Math.max(ans, maxH*(i-j+1));
            }
        }
        return ans;
    }
    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for( int i = 0 ; i < heights.length; i++){
            while(stack.peek()!=-1 && heights[stack.peek()] > heights[i]){
                int h = heights[ stack.pop()];
                int w = i - stack.peek() - 1;
                ans = Math.max( ans, h*w);
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int h = heights[ stack.pop()];
            int w = heights.length - stack.peek() - 1;
            ans = Math.max( ans, h*w);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(arr));
    }
}
