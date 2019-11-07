package c2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class q7 {

    static public boolean isPalindrome(Node<Integer> head){
       Node<Integer> r = reverse(head,null);
       Node<Integer> c = head;
       while(c != null && r != null){
           if (c.data!=r.data){
               return false;
           }
           c = c.next;
           r = r.next;
       }
       return true;
    }
    static public Node reverse(Node<Integer> head, Node<Integer> acc){
        if ( head == null ){
            return acc;
        }else {
            Node<Integer> copy = new Node<>(head.data);
            copy.next = acc;
            return reverse(head.next, copy);
         }
    }
    static public boolean isPalindrome2(Node<Integer> head) {
       Node<Integer> fast = head;
       Node<Integer> slow = head;
       Deque<Integer> stack = new LinkedList<>();
       while(fast != null && fast.next != null ){
           stack.push(slow.data);
           slow = slow.next;
           fast = fast.next.next;
       }
       if (fast!=null){
           slow = slow.next;
       }
       while ( slow != null){
         Integer v = stack.pop();
         if (v != slow.data){
             return false;
         }
         slow = slow.next;
       }
       return true;
    }
    public static void main(String[] args) {
        Node<Integer> l1 = new Node<>(0);
        l1.add(1).add(3).add(1).add(0);
        System.out.println(isPalindrome(l1));
        System.out.println(isPalindrome2(l1));
    }

}
