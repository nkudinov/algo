package g;

import java.util.*;

public class q13_1 {

    static class Logger {
        static class Pair {
            String  msg;
            Integer time;

            public Pair(String msg, Integer time) {
                this.msg = msg;
                this.time = time;
            }
        }
        PriorityQueue<Pair> windows;
        Set<String> msgSet;

        /**
         * Initialize your data structure here.
         */
        public Logger() {
            windows = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.time - o2.time;
                }
            });
            msgSet = new HashSet<>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (windows.size() > 0) {
                while (!windows.isEmpty() && windows.peek().time < timestamp) {
                    String msg = windows.poll().msg;
                    msgSet.remove(msg);
                }
            }
            if (msgSet.contains(message)) {
                return false;
            } else {
                windows.add(new Pair(message, timestamp + 10));
                msgSet.add(message);

            }
            return true;
        }

        public static void main(String[] args) {
            Logger l = new Logger();
            System.out.println(l.shouldPrintMessage(1,"foo"));
            System.out.println(l.shouldPrintMessage(2,"bar"));
            System.out.println(l.shouldPrintMessage(3,"foo"));
            System.out.println(l.shouldPrintMessage(8,"bar"));
            System.out.println(l.shouldPrintMessage(10,"foo"));
            System.out.println(l.shouldPrintMessage(11,"foo"));
        }
    }
}