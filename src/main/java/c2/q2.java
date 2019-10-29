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
    public static  <A> A nthToLast1(Node<A> head,int n){
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
    public static  <A> int nthToLast2(Node<A> head,int n){
       if (head == null){
           return 0;
       } else {
           int i = nthToLast2(head.next,n )+1;
           if (i == n){
               System.out.println(head.data);
           }
           return i;
       }
    }
    private static <A> A helper(Node<A> head,int n,int[] acc){
        if (head == null){
            acc[0] = 0;
            return null;
        }
        A a = helper( head.next, n, acc);
        acc[0] = acc[0] + 1;
        if (acc[0] == n){
            return head.data;
        }
        return a;
    }
    public static  <A> A nthToLast3(Node<A> head,int n){
      return helper(head,n, new int[1]);
    }
    public static void main(String[] args) {
        Node<Integer> h = new Node<>(1);
        h.add(2).add(3);
        System.out.println(nthToLast3(h,3));
    }
}
