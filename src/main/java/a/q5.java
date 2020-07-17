package a;

import java.lang.reflect.Array;
import java.util.Arrays;

public class q5 {
    static long f1(int n){
      if (n <=1){
          return n;
      }
      return f1(n-1)+f1(n-2);
    }
    static long f2(int n){
        long fn_1 = 1;
        long fn_2 = 1;
        long ret  = 0;
        for(int i = 3; i <= n; i++){
           ret = fn_1 + fn_2;
           fn_2 = fn_1;
           fn_1 = ret;
        }
        return ret;
    }
    static long f3(int n){
        long[] arr = new long[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <=n ; i++){
           arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }
    public static void main(String[] args) {
        System.out.println(f2(100));
        //System.out.println(f1(100));
        System.out.println(f3(100));
    }
}
