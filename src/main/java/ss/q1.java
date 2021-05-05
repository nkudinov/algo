package ss;

import java.util.HashMap;
import java.util.Map;

public class q1 {

    public static int numTriplets(int[] nums1, int[] nums2) {
        int ans = 0 ;
        /*
        [1,1]
        [1,1,1]
        */
        Map<Long,Integer> map1 = new HashMap<>();
        for(int e:nums1){
            map1.merge( (long)e*(long)e, 1, (a,b) -> a+b);
        }
        Map<Long,Integer> map2 = new HashMap<>();
        for(int e:nums2){
            map2.merge( (long)e*(long)e, 1, (a,b) -> a+b);
        }
        for(int i = 0 ; i < nums1.length-1;i++){
            for(int j = i+1; j < nums1.length; j++){
                ans += map2.getOrDefault( (long)nums1[i]*(long)nums1[j], 0);
            }
        }
        System.out.println(ans);
        for(int i = 0 ; i < nums2.length-1;i++){
            for(int j = i+1; j < nums2.length; j++){
                ans += map1.getOrDefault( (long)nums2[i]*(long)nums2[j], 0);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,1};
        int[] num2 = new int[]{1,1,1};
         System.out.println(numTriplets(num1, num2));
    }
}
