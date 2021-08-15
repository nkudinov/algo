package sedgewick.w2;

import java.util.Stack;

public class calc {

    public static int calculate(String s) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(0);
        Stack<Character> s2 = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                int val = 0;
                while ( i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                s1.push(val);
                i--;
            } else if ( ch == ' ' || ch =='(') {
                continue;
            } else if ( ch == '+' || ch == '-'){
                if (!s2.isEmpty()){
                    int a = s1.pop();
                    int b = s1.pop();
                    char op = s2.pop();
                    if ( op == '+'){
                        s1.push(b+a);
                    } else {
                        s1.push(b-a);
                    }
                }
                s2.push(ch);
            } else if ( ch == ')' && !s2.isEmpty()){
                int a = s1.pop();
                int b = s1.pop();
                char op = s2.pop();
                if ( op == '+'){
                    s1.push(b+a);
                } else {
                    s1.push(b-a);
                }
            }
        }
        while (!s2.isEmpty()){
            int a = s1.pop();
            int b = s1.pop();
            char op = s2.pop();
            if ( op == '+'){
                s1.push(b+a);
            } else {
                s1.push(b-a);
            }
        }
        int ans = 0;
        for(int x:s1){
            ans += x;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s=  "- (3 + (4 + 5))";
        System.out.println(calculate(s));
    }
}
