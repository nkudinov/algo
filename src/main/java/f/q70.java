package f;

import java.util.Comparator;
import java.util.PriorityQueue;

public class q70 {
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                if (l1.val < l2.val){
                    return -1;
                } else if (l1.val == l2.val){
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for(ListNode list:lists){
            q.add(list);
        }
        ListNode preHeader = new ListNode(0);
        ListNode tail = preHeader;

        while(!q.isEmpty()){
            tail.next = q.poll();
            tail = tail.next;
            if( tail.next!=null){
                q.add(tail.next);
            }
        }
        return preHeader.next;
    }

    public static void main(String[] args) {

    }
}
