package lc.june2020;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        int[] arr = new int[]{0,0};
        double[] probability = new double[arr.length];
        int N = 1000000;
        Random r = new Random();
        for(int i =0;i < N;i++){
            arr[r.nextInt(2)] += 1;
        }
        for(int i =0;i < arr.length;i++){
            probability[i] = arr[i]*1.0/N;
        }
        System.out.println(Arrays.toString(probability));
    }
}
