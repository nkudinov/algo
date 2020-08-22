package f;

public class q38 {
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
    static public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
           fast = fast.next.next;
           slow = slow.next;
        }
        //reverse slow
        // 1->2
        // 4 -> 3
        ListNode prev = null;
        ListNode curr = slow;
        ListNode tmp  = null;
        while( curr != null){
            tmp  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // merge head,prev
        //
        //prev
        ListNode first = head, second = prev;
        while(second.next!=null){

            tmp = first.next;
            first.next  = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;

        }


    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,null))));

        System.out.println(" ");
        reorderList(l1);
        print(l1);
    }

}
