package lc.june2020;

import java.util.Arrays;

public class q27 {
    static public int numSquares(int n) {
        int ret = Integer.MAX_VALUE;
        int N = (int)Math.floor(Math.sqrt(n));
        int[][] arr = new int[N+1][n+1];
        for(int i = 0; i < n;i++){
            arr[0][i] = 0;
        }
        for( int i = 1; i <  arr.length; i++) {
             for(int j = 1; j <= n; j++){
                if (  j >= (i*i) ){
                    int val = j/(i*i);
                    int delta = j-val*(i*i);
                    if ( i>1){
                      arr[i][j] = Math.min(val + arr[i-1][delta],arr[i-1][j]);
                    } else {
                        arr[i][j] = val + arr[i-1][delta];
                    }
                } else{
                   arr[i][j] = arr[i-1][j];
                }
             }
        }
        return arr[N][n];
    }
    public static void main(String[] args) {
        System.out.println(numSquares(43));
    }
}
