package a;



import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class q6 {
    static class Queue1<T> {
        private Stack<T> s1 = new Stack<>();
        private Stack<T> s2 = new Stack<>();

        public Queue1() {

        }
        public T deque(){
           while(!s1.isEmpty()){
               s2.push(s1.pop());
           }
           T ret = s2.pop();
           while (!s2.isEmpty()){
               s1.push(s2.pop());
           }
           return ret;
        }
        public void enque(T e){
            s1.push(e);
        }
    }

    public static void main(String[] args) {
        Queue1<Integer> q = new Queue1<>();
        q.enque(1);
        q.enque(2);
        System.out.println(q.deque());
        System.out.println(q.deque());
    }
}
