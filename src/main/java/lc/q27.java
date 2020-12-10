package lc;

import java.util.HashMap;
import java.util.Map;

public class q27 {
    public static int twoSumCount(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int N = arr.length;
        int ans = 0;
        for(int i = 0; i < N; i++){
            int complement = (target - arr[i]);
            ans += map.getOrDefault( complement, 0);
            map.merge( arr[i],1, (a,b) -> a+b);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        System.out.println(twoSumCount(arr, 6));
    }

}
