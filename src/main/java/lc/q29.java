package lc;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class q29 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int val, ListNode prev){
            this.val  = val;
            this.prev = prev;
        }
    }

    Map<Integer,Integer> val2freq;
    Map<Integer,ListNode> val2node;
    ListNode preHeader;
    ListNode last;
    public q29(int[] nums) {
        preHeader = new ListNode(-1, null);
        last = preHeader;
        val2freq = new HashMap<>();
        val2node = new HashMap<>();
        for(int x: nums){
            add(x);
        }
    }

    public int showFirstUnique() {
        if (preHeader.next != null){
            return preHeader.next.val;
        }
        return -1;
    }
    void print(){
        ListNode curr = preHeader;
        while(curr != null){
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public void add(int value) {
        System.out.println("adding " + value);
        if (!val2freq.containsKey(value)){
            val2freq.put(value, 1);
            ListNode node = new ListNode(value, last);
            last.next = node;
            last = last.next;
            val2node.put(value, node);
        } else {
            val2freq.merge(value, 1, (a,b) ->  a + b);
            if (val2node.containsKey(value)){
                ListNode curr = val2node.get(value);
                if (curr.next == null){
                    System.out.println("removing last "+ curr.prev.val);
                    last = curr.prev;
                    last.next = null;
                } else {
                    ListNode next = curr.next;
                    ListNode prev = curr.prev;
                    prev.next = next;
                    next.prev = prev;
                }
                val2node.remove(value);
            }
        }
        print();
    }

    public static void main(String[] args) {
        q29 q = new q29(new int[]{2,3});
        q.add(2);
        q.add(3);
        Set<Integer> unique = new LinkedHashSet<>();
        System.out.println(q.showFirstUnique());
    }
}
