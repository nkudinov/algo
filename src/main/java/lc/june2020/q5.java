package lc.june2020;

import java.util.Arrays;
import java.util.Random;

public class q5 {
    int[] w;
    int sum = 0;
    Random rand = new Random();
    public q5(int[] w) {
        this.w = w;
        for(int i = 0; i < w.length; i++){
            sum += w[i];
        }
    }
    public int pickIndex() {
        int rnd = rand.nextInt(sum);
        int sum = 0;
        for(int i = 0 ; i < w.length;i++){
            sum += w[i];
            if ( rnd < sum){
                return i;
            }
        }
        return  -1;
    }
    public static void main(String[] args) {
        int[] w = new int[] {3,14,1,17};
        double[] w1 = new double[w.length];
        q5 s = new q5(w);
        for(int i=0;i<w.length;i++){
            w1[i] = Math.round(w[i]*10000.0/s.sum)/10000.0;
        }
        System.out.println(Arrays.toString(w1));
        int[] arr = new int[w.length];
        double[] probability = new double[w.length];
        int N = 1000000000;
        for(int i =0;i < N;i++){
            arr[s.pickIndex()] += 1;
        }
        for(int i =0;i < arr.length;i++){
            probability[i] = arr[i]*1.0/N;
        }
        System.out.println(Arrays.toString(probability));
    }
}
