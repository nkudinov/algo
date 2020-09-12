package g;

public class q5 {
    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n ==1 && head.next == null){
            return null;
        }
        ListNode preHead = new ListNode(0, head);
        ListNode node = preHead;

        for(int i = 1; i <= n + 1; i++){
            node = node.next;
        }

        ListNode curr = preHead;

        while(node  != null){
            node = node.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return preHead.next;
    }
    static public void print(ListNode head){
        while(head!=null){
            System.out.print("->"+head.val);
            head =  head.next;
        }
    }
    public static void main(String[] args) {
      //1,2,3,4,5
      //         ^
      //    ^
        ListNode head1 = new ListNode(1, new ListNode(2 , new ListNode(3 , new ListNode(4, new ListNode(5,null)))));
        print(removeNthFromEnd(head1 , 2));
        System.out.println(" ");
        // 1,2
        //
        ListNode head2 = new ListNode(1, new ListNode(2 , null));
        print(removeNthFromEnd(head2 , 2));

    }

}
