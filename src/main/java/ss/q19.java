package ss;

import java.util.Stack;

public class q19 {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result  = 0;
        int operand = 0;
        int sign    = 1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch>='0' && ch <='9'){
                operand = operand*10+(ch-'0');
            } else if (ch == '+'){
                result = result + sign*operand;
                operand = 0;
                sign    = 1;
            } else if (ch == '-'){
                result = result + sign*operand;
                operand = 0;
                sign    = -1;
            } else if ( ch == '(' ) {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if ( ch == ')' ) {
                result += sign * operand;
                operand = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
            }
        }
        if (operand!=0){
            result = result + sign*operand;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(calculate("2+3-1+(1+1)"));
    }

}
