package f;

import java.util.Arrays;

public class q11 {
    static boolean balancedSplitExists(int[] arr) {
        Arrays.sort(arr);
        int lSum = 0;
        for(int e:arr){
            lSum += e;
        }
        int rSum = 0;
        for(int i = arr.length-1; i >= 1; i--){
            lSum -= arr[i];
            rSum += arr[i];
            if (lSum == rSum){
                if (arr[i-1] < arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //12, 7, 6, 7, 6
        //6,6,7,7,12

        System.out.println(balancedSplitExists(new int[]{12, 7, 6, 7, 6}));
        System.out.println(balancedSplitExists(new int[]{3, 3, 4, 4, 6}));

    }
}
