package f;

import java.util.Stack;

public class q75 {
    public static int calculate(String s) {
        int N = s.length();
        if ( s == null || N == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        char prevOperator = '+';
        int value = 0;
        for(int i = 0; i < N ;i++){
            char ch = s.charAt(i);
            if ( Character.isDigit(ch)){
                value = value*10 + (ch -'0');
            }
            if ( !Character.isDigit(ch) || i == N -1) {
                if (prevOperator == '+'){
                    stack.push(value);
                } else if (prevOperator == '-'){
                    stack.push(-value);
                } else if (prevOperator == '*'){
                    int prev = stack.pop();
                    stack.push(prev*value);
                }	else if (prevOperator == '/'){
                    stack.push(stack.pop()/value);
                }
                value = 0;
                prevOperator = ch;
            }

        }
        int ret = 0;
        for(Integer elem:stack){
            ret += elem;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3/2"));
    }
}
