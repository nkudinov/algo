package am;

import java.util.ArrayList;
import java.util.List;

public class q17 {
    public static void helper(int n, List<String> acc, int leftCount, int rightCount, String curr){
        if ( n == 0 ){
            if (leftCount == rightCount){
                acc.add(curr);
            }
            return;
        }
        helper(n - 1, acc, leftCount + 1, rightCount, curr + "(");
        if ( leftCount > rightCount){
            helper(n -1, acc, leftCount, rightCount + 1, curr + ")");
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if ( n == 0){
            return ans;
        }
        helper(2*n, ans,0,0,"");
        return ans;
    }

    public static void main(String[] args) {
        System.out.println( generateParenthesis(2));
    }

}
