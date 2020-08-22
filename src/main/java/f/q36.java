package f;

import java.util.List;

public class q36 {
    static class ListNode {
        int value;
        ListNode next;
        ListNode(int value, ListNode next){
            this.value = value;
            this.next  = next;
        }
    }
    public static void print(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.value+" ->");
            curr = curr.next;
        }
    }
    public static ListNode reverse1(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = reverse1( head.next);
        ListNode nxt = head.next;
        nxt.next = head;
        head.next = null;

        return tmp;
    }
    public static ListNode reverse2(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while( curr!= null){
            // 1, 2, 3
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
    //1,2,3
    //
    public static ListNode helper( ListNode curr , ListNode acc){
        if ( curr == null  ) {
            return acc;
        }
        ListNode newAcc = new ListNode( curr.value, acc);
        return helper( curr.next , newAcc);
    }
    public static ListNode reverse3(ListNode head){
        return helper(head, null);
    }
    public static void main(String[] args) {
       ListNode l1 = new ListNode(1,null);
       ListNode l2 = new ListNode(2, l1);
       ListNode l3 = new ListNode(3, l2);
        print( l3);
        System.out.println(" ");
        print(reverse3(l3));
    }

}
