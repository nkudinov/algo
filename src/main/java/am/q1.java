package am;

public class q1 {
    public static int trap(int[] height) {
       int l = 0;
       int r = height.length-1;
       int lMax = 0;
       int rMax = 0;
       int ans  = 0;
       while( l < r){
           if ( height[l] <= height[r]){
               if ( lMax < height[l]){
                   lMax = height[l];
               } else {
                   ans += lMax - height[l];
               }
               l++;
           } else {
               if ( rMax < height[r]){
                   rMax = height[r];
               }else {
                   ans += rMax - height[r];
               }
               r--;
           }
       }
       return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,3,0,1,0,2};
        System.out.println(trap(arr));
    }

}
