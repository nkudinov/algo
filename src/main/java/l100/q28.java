package l100;

import java.util.ArrayList;
import java.util.List;

public class q28 {
    static int helper(int i, int[] A, List<Integer> acc){
        if ( i == A.length ){
            if (acc.size() < 3) {
                return 0;
            }
            long diff = acc.get(1) - acc.get(0);
            for (int j = 1; j < acc.size(); j++) {
                if (acc.get(j) - acc.get(j - 1) != diff) {
                    return 0;
                }
                System.out.println(acc.get(j) - acc.get(j - 1) +": "+ acc.get(j)+"-" + acc.get(j - 1));
            }
            return 1;
        }
        List<Integer> acc1 = new ArrayList<>(acc);
        acc1.add(A[i]);
        return helper(i+1, A, acc)+helper(i+1,A, acc1);
    }
    public static int numberOfArithmeticSlices(int[] A) {
        return helper(0, A, new ArrayList<Integer>());
    }
    public static void main(String[] args) {
        System.out.println(-294967296-2000000000);
        //System.out.println(numberOfArithmeticSlices(new int[]{0,2000000000,-294967296}));
    }
}
