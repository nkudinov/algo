package g;

import java.util.LinkedList;

public class q13 {

     static class Logger {
         static class Node {
             String val;
             int time;
             boolean isPrinted;
             Node next;

             public Node(String val, int time) {
                 this.val = val;
                 this.time = time;
                 this.isPrinted = true;
             }
         }
         Node head;
        /** Initialize your data structure here. */
        public Logger() {
            head = new Node("",-1);
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
         public boolean shouldPrintMessage(int timestamp, String message) {
              Node node = new Node(message, timestamp);
              if (head.next == null){
                  head.next = node;
              } else {
                  Node tmp  = head.next;
                  head.next = node;
                  node.next = tmp;
              }
              Node curr = node.next;
              while( curr!= null && curr.time > timestamp-10){
                  if (curr.isPrinted && curr.val.equals(message)){
                      node.isPrinted = false;
                  }
                  curr = curr.next;
              }
              if ( curr!=null){
                  curr.next = null;
              }
              return node.isPrinted;
        }
    }
    public static void main(String[] args) {
        Logger l = new Logger();
        l.shouldPrintMessage(1,"foo");
        l.shouldPrintMessage(2,"bar");
        l.shouldPrintMessage(3,"foo");
        l.shouldPrintMessage(8,"bar");
        l.shouldPrintMessage(10,"foo");
        System.out.println(l.shouldPrintMessage(11,"foo"));


    }
}
