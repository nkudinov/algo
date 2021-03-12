package l100;

import java.util.Collections;
import java.util.PriorityQueue;

public class q57 {
    static class Item {
        String name;
        public int cnt;
        public Item(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) {

        Item i1 = new Item("One",0);
        Item i2 = new Item("Two",1);
        PriorityQueue<Item> q = new PriorityQueue<>( (a, b) -> a.cnt - b.cnt);
        q.add(i1);
        q.add(i2);
        i1.cnt = 100;
        System.out.println(q.poll().name);
    }
}
