package lc.june2020;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Solution {
    int[] w;

    double[] probabilities;
    int[] hits;
    double[] currentProbabilities;
    int current_total = 0;

    int total = 0;

    public Solution(int[] w) {
        this.w = w;
        this.probabilities = new double[w.length];
        this.currentProbabilities = new double[w.length];
        this.hits = new int[w.length];
        for(int i = 0; i< w.length;i++){
            total += w[i];
        }
        for(int i = 0; i< w.length;i++){
            probabilities[i] = w[i]*1.0/total;
            currentProbabilities[i] = 0;
        }

    }
    public double calculateDelta(double[] newProbabilities){
        double ret = 0;
        for(int i = 0; i < w.length; i++) {
           ret += Math.pow(newProbabilities[i]-probabilities[i],2);
        }
        return ret;
    }
    public int getIndexForMinDelta(){
        int index = 0;
        double delta = 0;
        for(int i=0;i < w.length;i++){
            delta += Math.abs( currentProbabilities[i]-probabilities[i]);
        }
        double minimum = calcDelta(delta, currentProbabilities[index],index);
        for(int i = 1;i < w.length;i++){
            double current = calcDelta(delta, currentProbabilities[i], i);
            if ( minimum > current){
                minimum = current;
                index = i;
            }
        }
        return index;
    }
    public double calcDelta(double delta, double probability, int index){
        return delta - Math.abs(currentProbabilities[index]-probabilities[index]) + Math.abs((hits[index]+1)*1.0 / (current_total + 1) - probabilities[index]);
    }
    public void recalculateCurrentProbabilities(int index){
        hits[index] +=1;
        current_total +=1;
        for(int i=0; i< w.length;i++){
            currentProbabilities[i]  = hits[i]*1.0/current_total;
        }
    }
    public int pickIndex() {
        int index = getIndexForMinDelta();
        recalculateCurrentProbabilities(index);

        return index;
    }
    public static void main(String[] args) {
        int[] w = new int[] {3,14,1,17};
        double[] w1 = new double[w.length];
        Solution s = new Solution(w);
        for(int i=0;i<w.length;i++){
           w1[i] = Math.round(w[i]*10000.0/s.total)/10000.0;
        }
        System.out.println(Arrays.toString(w1));
        int[] arr = new int[w.length];
        double[] probability = new double[w.length];
        long N = 100000;
        for(long i =0;i < N;i++){
            arr[s.pickIndex()] += 1;
        }
        for(int i =0;i < arr.length;i++){
            probability[i] = arr[i]*1.0/N;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(probability));
    }

}
