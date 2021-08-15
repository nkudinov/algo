import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    // construct an empty randomized queuq
    private Item[] arr;
    private int idx;
    private int size;
    private Random rand;
    public RandomizedQueue(){
        idx   = 0;
        arr   = (Item[])(new Object[2]);
        size  = 0;
        rand  = new Random(42);
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if ( idx < arr.length){
            arr[idx++] = item;
        } else {
            Item[] tmp = (Item[])(new Object[arr.length*2]);
            for(int i = 0; i < arr.length;i++){
                tmp[i] = arr[i];
            }
            arr = tmp;
        }
        size++;
    }

    // remove and return a random item
    public Item dequeue(){
        int i = rand.nextInt(size+1);
        return arr[i];
    }

    // return a random item (but do not remove it)
    public Item sample(){
        int i = rand.nextInt(size+1);
        return arr[i];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Item next() {
                return null;
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);

    }

}