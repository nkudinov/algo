package c17;

public class q8 {
   public static int maxSum(int[] arr){
     int maxSum = 0;
     int sum  = 0;
     for (int i =0 ;  i < arr.length; i++ ){
         sum += arr[i];
         if (sum > maxSum){
             maxSum = sum;
         }
         if (sum < 0){
             sum =0;
         }
     }
     return maxSum;
   }
   public static void main(String[] args) {
          int[] arr ={ -8, 3, -2, 4, -10};
          System.out.println(maxSum(arr));
   }
}
