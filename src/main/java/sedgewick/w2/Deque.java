import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    static private class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
        Node(Item item, Node<Item> prev, Node<Item> next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    private Node<Item> front;
    private Node<Item> back;
    private int size;
    // construct an empty deque
    public Deque(){
        front = null;
        back  = null;
        size  = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item){
        if ( item == null){
            throw new IllegalArgumentException();
        }

        //   A->B->C
        //
        front = new Node<>(item, null, front);
        size++;
    }

    // add the item to the back
    public void addLast(Item item){
        if ( item == null){
            throw new IllegalArgumentException();
        }
        back.next = new Node<>(item, back ,null);
        back = back.next;
        size--;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if ( size == 0){
            throw new java.util.NoSuchElementException();
        }
        Node<Item> old = front;
        front = front.next;
        old.next = null;
        old.prev = null;
        size--;
        return old.item;
    }

    // remove and return the item from the back
    public Item removeLast(){
         Node<Item> old = back;
         back = back.prev;
         old.prev = null;
         old.next = null;
         return old.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new Iterator<Item>() {
            Node<Item> curr = front;
            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public Item next() {
                Item item = curr.item;
                curr = curr.next;
                return item;
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args){
       Deque<Integer> d = new Deque<>();
       d.addFirst(1);
       d.addFirst(2);
       for(Integer x:d){
           System.out.println(x);
       }
    }

}