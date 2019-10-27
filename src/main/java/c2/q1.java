package c2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Node<A> {
    Node<A> next = null;
    A data;

    public Node(A data) {
        this.data = data;
    }
    public Node<A> add(A data){
        Node<A> node = new Node<>(data);
        this.next = node;
        return node;
    }
    public void println(){
        Node<A> elem  = this;
        while( elem != null){
            System.out.println(elem.data);
            elem = elem.next;
        }
    }
}
public class q1 {
    public static <A>  void removeDublicates(Node<A> head){
        Set<A> set = new HashSet<>();
        Node<A> elem  = head;
        Node<A> prev  = null;
        while( elem != null){
            if (set.contains(elem.data)){
              prev.next = elem.next;
            } else {
              set.add(elem.data);
              prev = elem;
            }
            elem = elem.next;
        }
    }
    public static void main(String[] args) {
        Node<Integer> h = new Node<>(1);
        h.add(1).add(1);
        removeDublicates(h);
        h.println();

    }
}
