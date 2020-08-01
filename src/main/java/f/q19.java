package f;

import java.util.Arrays;

public class q19 {
    static int[] findMinArray(int[] arr, int k) {
        if (arr.length <=1){
            return arr;
        }
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        int start = 0;
        while( start < arr.length && arr[start] ==sorted[start]){
            start++;
        }
        for(int i = 1; i<=k;i++){
            int j = start+start;
            for(int z = start+1; z <= start+k && z < arr.length; z++){
                if (arr[z] < arr[j]){
                    j = z;
                }
            }
            if (j!=0) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3, 2};
        System.out.println(Arrays.toString(findMinArray(arr,2)));
    }
}
