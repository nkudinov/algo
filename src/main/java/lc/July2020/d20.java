package lc.July2020;

public class d20 {
    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    static public ListNode removeElements(ListNode head, int val) {
        if ( head == null){
            return null;
        }
        ListNode ret = head;

        while( ret!=null && ret.val == val) {
           ret = ret.next;
        }
        if (ret == null){
            return null;
        }
        ListNode curr = ret;
        while ( curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return ret;
    }
    static public void print(ListNode head){
        ListNode curr = head;
        while (curr != null){
            if (curr.next!=null) {
                System.out.print(curr.val + "->");
            }else {
                System.out.print(curr.val);
            }
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode f2 = new ListNode(1);
        ListNode f1 = new ListNode(1,f2);
        ListNode f  = new ListNode(1,f1);
        print(f);
        print(removeElements(f,1));
    }
}
