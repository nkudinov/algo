package f;

import java.util.*;

public class q43 {
    static public void helper( String s, String curr, int leftCount, int rightCount, int numRemoved, Set<String> acc){
       if ( s == null || s.length() == 0){
          if ( leftCount == rightCount){
              if (acc.size() == 0) {
                  acc.add(curr);
              } else {
                  if (curr.length() >= acc.iterator().next().length()){
                      acc.add(curr);
                  }
              }
          }
       } else {
          char ch = s.charAt(0);
          if ( ch == '(' || ch ==')'){
              if ( ch == '(' && leftCount >= rightCount ){
                  helper(s.substring(1), curr + ch, leftCount + 1, rightCount, numRemoved , acc);
              } else if ( ch == ')' && leftCount >= rightCount ){
                  helper(s.substring(1), curr + ch, leftCount, rightCount + 1, numRemoved , acc);
              }
              helper(s.substring(1), curr, leftCount, rightCount ,numRemoved + 1, acc);
          } else {
              helper( s.substring(1), curr+ ch, leftCount, rightCount ,numRemoved , acc);
          }
       }
    }
    static public List<String> removeInvalidParentheses(String s) {
          Set<String> res  = new HashSet<>();
          helper(s, "", 0, 0, 0, res);
          return new ArrayList<>(res);
    }
    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("(a)())()"));
    }

}
