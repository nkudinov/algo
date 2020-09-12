package g;

import java.util.Stack;

 class MinStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** initialize your data structure here. */

    public MinStack() {
         stack1 = new Stack<>();
         stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x){
            stack2.push(x);
        }
    }

    public void pop() {
        int x = stack1.pop();
        if (stack2.peek() == x){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);

    }
}
