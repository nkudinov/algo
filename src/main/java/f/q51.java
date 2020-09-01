package f;

import java.util.Stack;

public class q51 {
    static public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(ch);
            } else if (ch ==')'){
                if (stack.isEmpty() || stack.peek() !='(') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    static public int longestValidParentheses(String s) {
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++ ){
            for(int j = i+1; j <= s.length(); j++){
                if (isValid( s.substring(i,j))){
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }

}
