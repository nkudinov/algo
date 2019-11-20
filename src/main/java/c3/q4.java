package c3;

import java.util.Stack;

public class q4 {
    public static void moveDisks(int n, Stack<Integer> origin, Stack<Integer>  destination,Stack<Integer>  buffer){
        if (n<=0){
            return;
        }
        moveDisks(n-1,origin,buffer,destination);
        destination.push(origin.pop());
        moveDisks(n-1,buffer,destination,origin);

    }
    public static void main(String[] args) {
       java.util.Stack<Integer> origin = new Stack<>();
       java.util.Stack<Integer> buffer = new Stack<>();
       java.util.Stack<Integer> destination = new Stack<>();
       origin.push(4);
       origin.push(3);
       origin.push(2);
       origin.push(1);
       moveDisks(origin.size(),origin,destination,buffer);
       System.out.println(origin.toString());
       System.out.println(buffer.toString());
       System.out.println(destination.toString());
    }

}

