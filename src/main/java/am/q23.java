package am;

public class q23 {
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public static ListNode reverseLinkedList(ListNode head, int k) {
      ListNode curr = head;
      ListNode prev = null;
      while ( k> 0 ){
          ListNode tmp = curr.next;
          curr.next = prev;
          prev = curr;
          curr = tmp;
          k--;
      }
      return prev;
  }
    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while (count!=k && curr!=null){
            curr = curr.next;
            count++;
        }
        if (count == k ){
            ListNode reversed = reverseLinkedList(head, k);
            head.next = reverseKGroup(curr, k);
            return reversed;
        }
        return head;
    }
    public static ListNode reverse(ListNode head) {
        ListNode curr    = head;
        ListNode prev    = null;
        while ( curr != null ){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
  public static void print(ListNode head){
      ListNode curr = head;
      System.out.print("list [ ");
      while (curr != null){
          System.out.print( curr.val +"->");
          curr = curr.next;
      }
      System.out.println("]");
  }

  public static void main(String[] args) {
     ListNode n1 = new ListNode(1);
     ListNode n2 = new ListNode(2,n1);
     ListNode n3 = new ListNode(3,n2);
     ListNode n4 = new ListNode(4,n3);
     print(n4);
     print(reverseKGroup(n4,2));
  }
}
