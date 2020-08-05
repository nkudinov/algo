package lc.aug2020;

import scala.Array;
import scala.reflect.internal.util.Collections;

public class d4 {
    public static boolean isPowerOfFour(int num) {
        int cnt = 0;
        for(int i = 0; i <=31 ;i++){
            int bit = (num & (1<<i) );
            if (  bit == 1 ){
                cnt++;
                if (cnt != 1 ) {
                    return false;
                }
                if (i%2!=0 ) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(isPowerOfFour(5));
    }

}
