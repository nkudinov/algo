package c2;



public class q2 {
    private static  <A> int length(Node<A> head){
        int len = 0;
        Node<A> current = head;
        while( current != null){
            current = current.next;
            len++;
        }
        return len;
    }
    public static  <A> A nthToLast(Node<A> head,int n){
        int len = length(head);
        if (len < n){
            throw new IllegalArgumentException("n must be <= " + len);
        }
        Node<A> current = head;
        while(len != n){
            current = current.next;
            len--;
        }
        return current.data;
    }

    public static void main(String[] args) {
        Node<Integer> h = new Node<>(1);
        h.add(2).add(3);
        System.out.println(nthToLast(h,10));
    }
}
