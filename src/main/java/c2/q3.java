package c2;

public class q3 {
    public static boolean deleteNode(Node node){
        if ( node == null || node.next == null){
            return false;
        } else {
            node.data = node.next.data;
            node.next = node.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node<Integer> h = new Node<>(1);
        h.add(2).add(3);
        System.out.println(deleteNode(h));
        h.println();
    }
}
