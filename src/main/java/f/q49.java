package f;

import java.util.HashMap;
import java.util.Map;

 class LRUCache {
    static class Node {
        int value;
        int key;
        Node next;
        Node prev;
    }
    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        head.value = 0;
        tail = new Node();
        tail.value = -1;
        head.next = tail;
        tail.prev = head;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void modeToHead(Node node){
        remove(node);
        addFirst(node);
    }
    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            modeToHead(node);
            return map.get(key).value;
        }
        return -1;
    }
    private void addFirst(Node node){
        // head,node1
        // head,node,tail
        Node node1 = head.next;
        node.next  = node1;
        node1.prev = node;
        head.next = node;
        node.prev = head;
    }
    private void removeLast(){
        Node curr = tail.prev;
        Node prev = curr.prev;
        prev.next = tail;
        tail.prev = prev;
         map.remove( curr.key);
    }
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            modeToHead(node);
        } else {
            Node node  = new Node();
            node.key    = key;
            node.value = value;
            addFirst(node);
            map.put( key, node);
            if (map.size() > capacity) {
                removeLast();
            }
        }

    }
     void print(){
        for(Map.Entry<Integer,Node> e:map.entrySet()){
            System.out.println(e);
        }
     }
     public static void main(String[] args) {
         LRUCache cache = new LRUCache(2);
         cache.put(1,10);
         cache.put(2,20);
         System.out.println(cache.get(1));
   //      System.out.println(cache.get(2));
         cache.put(3,30);
         System.out.println(cache.get(2));
         cache.print();
     }
}
