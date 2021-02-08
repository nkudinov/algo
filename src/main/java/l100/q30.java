package l100;

import java.util.HashSet;
import java.util.Set;

public class q30 {
    public  static  int primePalindrome(int N) {
        int max  = 2*100_000_000;

        boolean[] nums = new boolean[max];
        for( int i = 2; i < max; i++){
            for(int j = 2; i*j < max; j++){
                nums[i*j] = true;
            }
        }
        Set<Integer> set = new HashSet<>();

        for(int i = 2; i < max; i++){
            if (!nums[i] && i == reverse(i)){
                 set.add(i);
            }
        }
        System.out.println(set);
        while( true){
           if (set.contains(N)){
               return N;
           }
           N++;
        }
    }

    private static int reverse(int N) {
        int ans = 0;
        while( N > 0){
            ans = ans*10 + N%10;
            N = N/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(primePalindrome(13));
    }
}
