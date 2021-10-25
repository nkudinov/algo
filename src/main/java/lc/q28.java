package lc;

import java.util.Collections;
import java.util.TreeMap;

public class q28 {

    TreeMap<Integer, Integer> calendar;

    q28() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
