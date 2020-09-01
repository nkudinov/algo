package f;

public class q53 {
    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static public void print(Node head){
        while( head != null){
            System.out.print(head.value+"->");
            head = head.next;
        }
        System.out.println();
    }

    static public Node revert( Node head){
        // 1 -> 2 ->3
        Node curr = head;
        Node prev = null;
        while ( curr.next != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }

    public static void main(String[] args) {
       Node l9 = new Node(9,null);
       Node l8 = new Node(8, l9);
       Node l7 = new Node(7, l8);
       Node l6 = new Node(6, l7);
       print(revert(l6));
    }

}
