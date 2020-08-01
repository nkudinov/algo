package f;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class q16 {
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
    /*
    N = 6
    list = [1, 2, 8, 9, 12, 16]
    */
    static  Node reverse2(Node head) {
       if (head == null){
           return null;
       }
       Node curr = head;
       Stack<Node> evenStack = new Stack<>();
       Queue<Node> queue = new LinkedList<>();
       while (curr != null){
           int value = curr.data;
           if (value%2==0){
               evenStack.add(curr);
           } else {
               if (!evenStack.isEmpty()){
                  while(!evenStack.isEmpty()){
                      queue.add(evenStack.pop());
                  }
               }
               queue.add(curr);
           }
           curr = curr.next;
       }
       if (!evenStack.isEmpty()) {
           while (!evenStack.isEmpty()) {
               queue.add(evenStack.pop());
           }
       }
       Node ret = queue.remove();
       curr = ret;
       while(!queue.isEmpty()){
           curr.next = queue.remove();
           curr = curr.next;
       }
        curr.next =null;
       return ret;
    }
    static Node reverse(Node head, Node prev){
        if (head == null){
            return null;
        }
        Node temp = head;
        Node curr = head;
        // 2 -> 8->10
        //
        while( curr!=null && curr.data%2 == 0 ){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        if ( curr != head){
            head.next = curr;
            curr = reverse(curr, null);
            return prev;
        } else {
            //
            head.next = reverse( head.next, head);
            return head;
        }
    }
    static  Node reverse(Node head) {
        return reverse(head,null);
    }
    public static void main(String[] args) {
        Node e3 = new Node(5);
        Node e2 = new Node(4);
        e2.next = e3;
        Node e1 = new Node(2);
        e1.next = e2;
        Node head = new Node(1);
        head.next = e1;

        Node ret = reverse(head);
        while(ret!=null){
            System.out.print(ret.data+"->");
            ret = ret.next;
        }

    }

}
