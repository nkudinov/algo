package lc.june2020;

public class q2 {
    static class ListNode {
           int val;
           ListNode next;
           ListNode(int x) {
               val = x;
           }
    }
    public void deleteNode(ListNode node) {
        while( node.next != null){
           node.val = node.next.val;
           if (node.next.next == null){
               node.next = null;
           } else {
               node = node.next;
           }
        }
    }
    public static void main(String[] args) {

    }
}
