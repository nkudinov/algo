package c2;

public class q4 {
    public static Node partition(Node<Integer> head, Integer x){
      Node<Integer> lHead = null;
      Node<Integer> lTail = null;
      Node<Integer> bHead = null;
      Node<Integer> bTail = null;

      Node<Integer> curr  = head;
      while( curr!= null){
          Node<Integer> next = curr.next;
          curr.next=null;
          if ( curr.data <= x){
              if (lHead == null){
                  lHead = curr;
                  lTail = curr;
              } else {
                 lTail.next = curr;
                 lTail = curr;
              }
          }else {
              if (bHead == null){
                bHead = curr;
                bTail = curr;
              } else {
                 bTail.next = curr;
                  bTail = curr;
              }
          }
          curr = next;

      }
        if (lHead == null){
            return bHead;
        }
        lTail.next = bHead;
        return lHead;
    }

    public static void main(String[] args) {
        Node<Integer> h = new Node<>(1);
        h.add(2).add(10).add(0).add(3);
        partition(h,5).println();
    }
}
