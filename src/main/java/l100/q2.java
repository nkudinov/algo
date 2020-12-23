package l100;

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
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
}
