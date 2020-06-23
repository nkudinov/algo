package lc.june2020;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public class q22 {

        static public int singleNumber3(int[] nums) {
            int x1 = 0, x2 = 0, mask = 0;
            for (int i : nums) {
                x2 ^= x1 & i;
                x1 ^= i;
                mask = ~(x1 & x2);
                x2 &= mask;
                x1 &= mask;
            }
            return x1;
        }

        public static int singleNumber2(int[] nums) {
            int ret = 0;
            for(int i=0;i<32;i++){
                int cnt = 0;
                for(int j = 0; j < nums.length;j++ ){
                    cnt  = cnt + ((nums[j] >>i ) & 1);
                }
                if (cnt%3!=0){
                    ret = ret | 1 << i;
                }
            }
            return ret;
        }

        public static int singleNumber1(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length;i++){
                Integer key = nums[i];
                map.put(key, map.getOrDefault(key, 0)+1);
            }
            for(Map.Entry<Integer,Integer> e:map.entrySet()){
                if (e.getValue()==1){
                    return e.getKey();
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            int[] arr = new int[]{1,1,1,3,2,2,2};
            System.out.println(singleNumber3(arr));
        }

}
