package c2;

public class q5 {
    public static Node addLists(Node<Integer> l1, Node<Integer> l2, int carry){
        if (l1 == null && l2 == null && carry == 0 ){
            return null;
        }
        Node<Integer> curr = new Node<>(carry);

        if (l1 !=null) {
           curr.data += l1.data;
        }

        if (l2 != null) {
           curr.data += l2.data;
        }

        int newCarry  = curr.data/10;
        curr.data = curr.data %10;
        if ( l1 != null || l2 != null) {
            curr.next = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, newCarry);
        }
        return curr;
    }

    public static void main(String[] args) {
        Node<Integer> l1 = new Node<>(1);
        l1.add(2).add(3);

        Node<Integer> l2 = new Node<>(1);
        l2.add(8);

        addLists(l1,l2,0).println();

    }
}
