package z;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q1 {
    static public int[] solution(int N) {
       if ( N == 0) {
           return new int[]{};
       } else if (N == 2 ){
           return new int[]{1,-1};
       }
       int[] ret =  new int[N];
       for(int i = 0; i < N -1; i++){
           ret[i]    = i;
           ret[N-1] += i;
       }
       ret[N-1] = -ret[N-1];
       return ret;
    }
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++){
            int[] res = solution(i);
            int sum = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = 0; j < res.length; j++){
                if (map.containsKey(res[j])){
                    throw new RuntimeException("dublicate");
                }
                map.put(res[j], 1);
                sum = sum + res[j];
            }
            if ( sum != 0){
                throw new RuntimeException("eroor");
            }
        }
        System.out.println(Arrays.toString(solution(2)));
    }


}
