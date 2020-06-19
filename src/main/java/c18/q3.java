package c18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class q3 {

    static int getIndexByValue(int value, int[] arr){
        for(int i=0;i < arr.length;i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    static public Set<Integer> get(int[] arr, int m){
       Random rand = new Random();
       Set<Integer> ret = new HashSet<>();
       while(ret.size() < m){
          int i = rand.nextInt(arr.length);
          ret.add(arr[i]);
       }
       return ret;
    }
    public static void main(String[] args) {
       int[] arr = new int[] {0,1,2,3,4,5};
       int N = 100000;
       int[] hits = new int[arr.length];
       for(int i =0; i < N; i++){
            Set<Integer> tmp = get( arr,3);
            for(int e:tmp){
                hits[e]++;
            }
        }
        System.out.println(Arrays.toString(hits));
    }

}
