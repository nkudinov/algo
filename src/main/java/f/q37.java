package f;

import java.util.List;

public class q37 {
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode acc = new ListNode(0,null);
        ListNode ret = acc;
        ListNode curr = null;
        while(l1 !=null && l2!=null){

           if (l1.value < l2.value){
               curr = new ListNode( l1.value, null);
               l1 = l1.next;
           } else {
               curr = new ListNode( l2.value, null);
               l2 = l2.next;
           }
           acc.next = curr;
           acc = acc.next;

        }
        while(l1!=null){
            curr = new ListNode( l1.value, null);
            l1 = l1.next;
            acc.next = curr;
            acc = acc.next;
        }
        while (l2 != null) {
            curr = new ListNode( l2.value, null);
            l2 = l2.next;
            acc.next = curr;
            acc = acc.next;
        }
        return ret.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode acc = new ListNode(0,null);
        ListNode ret = acc;
        ListNode curr = null;
        while( l1 !=null && l2!=null){
           if (l1.value < l2.value){
               curr = l1;
               l1 = l1.next;
           } else{
               curr = l2;
               l2 = l2.next;
           }
           acc.next = curr;
           acc = acc.next;
        }
        if (l1!=null){
            acc.next =l1;
        } else {
            acc.next =l2;
        }
        return ret.next;
    }
    public static void main(String[] args) {
        // 1->2->4
        // 1->3->4
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4,null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4,null)));
        print(l1);
        System.out.println("");
        print(l2);
        System.out.println("");
        print( mergeTwoLists2(l1,l2));
    }
}
