package a;

import java.util.Arrays;
import java.util.Random;

public class q4 {
    static Random rnd = new Random();
    static int magicNumber() {
        return rnd.nextInt(2);
    }
    static public int nextInt(int bound){
        int ret = 0;
        int n   = 10;
        do {
            ret = 0;
            for(int i = 0; i < n; i++){
                int bit =  magicNumber();
                ret = ret | (bit << i);
            }
        } while( ret >= bound);
        return ret;
    }

    public static void main(String[] args) {
       double[] arr = new double[10];
       int N = 1000;
       for(int i = 0; i < N;i++){
           arr[ nextInt(10)] += 1.0;
       }
       for(int i=0; i < arr.length; i++){
           arr[i] = arr[i]/N;
       }
       System.out.println(Arrays.toString(arr));
    }
}
