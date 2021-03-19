package l100;

import java.util.TreeMap;
import java.util.TreeSet;

public class q60 {

    static class RecentCounter1 {
        TreeMap<Integer, Integer> tm;
        public RecentCounter1() {
            tm = new TreeMap<>();
        }

        public int ping(int t) {
            tm.put(t, 1 + tm.size());
          //  tm.merge();
            return tm.tailMap(t - 3000).size();
        }
    }

    static class RecentCounter2 {
        TreeSet<Integer> tm;
        public RecentCounter2() {
            tm = new TreeSet<>();
        }

        public int ping(int t) {
            tm.add(t);
            return tm.tailSet(t-3000).size();
        }
    }
}
