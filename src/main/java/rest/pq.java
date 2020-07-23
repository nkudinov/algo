package rest;

import java.util.Collections;
import java.util.PriorityQueue;

public class pq {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        p.add(1);
        p.add(10);
        p.add(2);
        while(p.size()!=0){
            System.out.println(p.poll());
        }
     }
}
