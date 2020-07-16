package sort;

import java.util.Arrays;

public class CountSort {

    static int[] sort(int[] arr){
        if (arr == null || arr.length <=1){
            return arr;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min+1;
        int[] counts = new int[range];
        int[] output = new int[arr.length];
        for(int i = 0; i< arr.length; i++){
            counts[arr[i]-min]++;
        }
        for(int i =1; i < counts.length;i++){
            counts[i] += counts[i-1];
        }
        for(int i = arr.length-1;i>=0;i--){
            output[counts[arr[i]-min]-1] = arr[i];
            counts[arr[i]-min]--;
        }

        System.out.println(Arrays.toString(counts));
        return output;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {2,4,1,8,1};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
