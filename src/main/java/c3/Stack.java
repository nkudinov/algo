package c3;

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

public class Stack {
    Node<Integer> top;
    public void push(Integer value){
        Node<Integer> node = new Node<>(value);
        node.next = top;
        top = node;
    }
    public Integer pop(){
        if ( top !=null ){
            Integer ret = top.data;
            top = top.next;
            return  ret;
        }
        return null;
    }
    public void println(){
        top.println();
    }
    public static void main(String[] args) {
     Stack stack = new Stack();
     stack.push(1);
     stack.push(10);
     stack.push(22);
     stack.pop();
     stack.println();
    }
}
