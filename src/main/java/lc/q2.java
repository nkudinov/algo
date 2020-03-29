package lc;

public class q2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = l1.val+l2.val;
        int over  = value/10;
        ListNode ret = new ListNode(value % 10);
        ListNode cur = ret;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null){
            value = over + (l1!=null?l1.val:0) + (l2!=null?l2.val:0);
            over  = value/10;
            cur.next =  new ListNode(value % 10);
            cur = cur.next;
            if (l1!=null) {
                l1 = l1.next;
            }
            if (l2!=null) {
                l2 = l2.next;
            }
        }
        if (over !=0){
            cur.next =  new ListNode(over);
        }
        return ret;
    }
    static ListNode makeList(int ...digits){
        ListNode ret = new ListNode(digits[0]);
        ListNode cur = ret;
        for(int i = 1; i < digits.length;i++){
               cur.next = new ListNode(digits[i]);
               cur = cur.next;
        }
        return ret;
    }
    static void printList(ListNode l ){
        while(l != null){
            System.out.print( l.val + (l.next==null?"\n":"->"));
            l = l.next;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = makeList(2,4,3);
        ListNode l2 = makeList(5,6);
        printList(l1);
        printList(l2);
        printList(addTwoNumbers(l1, l2));
    }
}
