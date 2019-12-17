package c7;

import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;

public class q0 {
    public static Integer[] sieveOfEratosthenes(int n){
        boolean[] tmp = new boolean[n+1];
        for(int i=2; i<=n; i++){
            tmp[i] = true;
        }
        for(int i=2; i <= Math.sqrt(n+1); i++){
            for(int j=i; j<=n;j++){
                if (tmp[j] && j%i == 0 && i!=j){
                    tmp[j] = false;
                }
            }
        }
        ArrayList<Integer> ret =  new ArrayList<>();
        for(int i=2; i<=n; i++){
            if (tmp[i]){
                ret.add(i);
            }
        }
        return ret.toArray(new Integer[ret.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieveOfEratosthenes(30)));
        System.out.println("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]");

    }
}
