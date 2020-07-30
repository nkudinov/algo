package f;


import java.util.Stack;

public class q15 {
    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character ch:s.toCharArray()){
            //{[()]}
            if (ch == '[' || ch =='(' || ch =='{'){
                stack.push(ch);
            } else if (ch == ']' || ch =='}' || ch ==')') {
                if (stack.size() == 0){
                    return false;
                }
                Character elem = stack.pop();
                if (ch == ']' && elem !='['){
                    return false;
                } else if (ch == '}' && elem != '{'){
                    return false;
                } else if (ch == ')' && elem != '('){
                    return false;
                }
            }
        }
        if (stack.size()!=0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isBalanced("{(})"));
    }
}
