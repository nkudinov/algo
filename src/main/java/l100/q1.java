package l100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class q1 {

    public static String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        for(char ch:path.toCharArray()){
            if ( ch == ']' ){
                LinkedList<Character> list = new LinkedList<>();
                while(stack.peek() != '['){
                    list.addFirst(stack.pop());
                }
                int k = 0;
                int base = 1;
                stack.pop();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    char digit = stack.pop();
                    k = k + (digit-'0')*base;
                    base *= 10;
                }
                while( k > 0){
                    for(int i = 0 ; i <list.size(); i++){
                        stack.push(list.get(i));
                    }
                    k--;
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:stack){
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("100[leetcode]"));
    }

}
