package c3;

import java.util.Deque;
import java.util.LinkedList;

public class q2 {
    static class Stack<A extends Comparable> {
       Deque<A> stack  = new LinkedList<>();
       Deque<A> mStack = new LinkedList<>();
       public void push(A value) {
           A minValue = mStack.peek();
           if ( minValue == null || minValue.compareTo(value) > 0 ){
              mStack.push(value);
           }
           stack.push(value);
       }
       public A pop (){
           return stack.pop();
       }
       public A min(){
           return mStack.peek();
       }
       public void print(){
           System.out.println("stack = " + stack.toString());
           System.out.println("min stack = " +mStack.toString());
       }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(10);
        stack.push(1);
        stack.push(200);
        stack.print();
        System.out.println(stack.min());
    }
}
