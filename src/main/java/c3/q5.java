package c3;

import java.util.Deque;
import java.util.LinkedList;

class MyQueue<A> {

  private Deque<A> in  = new LinkedList<>();
  private Deque<A> out = new LinkedList<>();

  public void enque(A value){
      while(!out.isEmpty()){
          in.push(out.pop());
      }
      in.push(value);
  }
  public A deque(){
     while(!in.isEmpty()){
        out.push(in.pop());
     }
     return out.pop();
  }
}
public class q5 {
    public static void main(String[] args) {
        MyQueue<Integer> q1 = new MyQueue<>();
        q1.enque(1);
        q1.enque(2);
        q1.enque(20);
        System.out.println(q1.deque());
        System.out.println(q1.deque());
        System.out.println(q1.deque());
    }
}
