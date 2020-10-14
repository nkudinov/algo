package lc;

import java.util.Stack;

public class q26 {
    static public int calculate1(String s) {
        int len;
        if( s==null || (len = s.length())==0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                } else if(sign=='+'){
                    stack.push(num);
                } else if(sign=='*'){
                    stack.push(stack.pop()*num);
                } else if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }
    static public int calculate(String s) {
       int len = s.length();
       char sign ='+';
       int num = 0;
       Stack<Integer> stack = new Stack<>();
       for(int i = 0; i < len; i++ ){
           char ch = s.charAt(i);
           if (ch >= '0' && ch<='9'){
               num += num*10 + (ch-'0');
           }
           if (!Character.isDigit(ch)){
             if ( sign == '+'){
                stack.push(num);
             } else if ( sign =='-'){
                stack.push(-num);
             } else if ( sign == '*'){
                stack.push(stack.pop()*num);
             } else if ( sign == '/'){
                 stack.push(stack.pop()/num);
             }
             sign = ch;
             num  = 0;
           }

       }
       int r = 0;
       for(Integer e:stack){
           r += e;
       }
       return r;
    }
    public static void main(String[] args) {
        System.out.println(calculate("2+3*4"));
    }
}
