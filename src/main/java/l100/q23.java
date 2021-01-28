package l100;

import java.util.ArrayList;
import java.util.List;

public class q23 {
    private static boolean helper1(int[] A, int i, int lSum, int lCnt, int rSum, int rCnt){
        if ( i < 0){
            if (lSum*1.0/lCnt == rSum*1.0/rCnt){
                return true;
            }
            return false;
        }
        int elem = A[i];
        boolean left  = helper1(A,i-1, lSum + elem, lCnt + 1, rSum, rCnt);
        boolean right = helper1(A,i-1, lSum , lCnt, rSum + elem, rCnt + 1);
        return left || right;
    }
    public static boolean splitArraySameAverage(int[] A) {
        return helper1(A, A.length-1, 0, 0, 0, 0 );
    }
    public static void main(String[] args) {
      // int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int[] arr = new int[]{3,1};
        //[60,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30]
        //int [] arr = new int[]{60,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30};
       System.out.println(splitArraySameAverage(arr));
    }
}
