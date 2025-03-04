import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class NSWG {
    static void check(int x, int n, int k, List<List<Integer>> list) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if ((x & (1 << i)) != 0) {
                tmp.add(i);
                k -= i;
            }
            ;
        }
        if (tmp.size() == n && k == 0) {
            list.add(tmp);
        }
    }

    static public List<List<Integer>> combinationSum3(int k, int n) {
        int max = 1 << 10 - 1;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            check(i, n, k, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println();
        for (List<Integer> l : combinationSum3(k, n)) {
            System.out.println(l);
        }
    }

}
