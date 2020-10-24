package f;

import java.util.HashMap;
import java.util.Map;

public class q72 {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int delta = sum - k;
            if ( map.containsKey( delta)){
                cnt += map.get(delta);
            }
            map.merge( sum, 1, (a,b) -> a+b);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,0,0,1};
        System.out.println(subarraySum(arr, 0));
    }
}
