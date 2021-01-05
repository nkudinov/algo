package l100;

import java.util.HashSet;
import java.util.Set;

public class q8 {
    private static boolean isUnique(int x){
        Set<Integer> set = new HashSet<>();
        int origin = x;
        while(x > 0){
            if (set.contains(x%10)){
                System.out.println(origin);
                return false;
            }
            set.add(x%10);
            x = x/10;
        }
        return true;
    }
    public static int countNumbersWithUniqueDigits(int n) {
        int N = (int)Math.pow(10,n);
        int count = 0;
        for(int i = 0; i < N; i++){
            if (isUnique(i)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(8));
    }
}
