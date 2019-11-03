package c2;

public class q6 {
    public static Node findBeginning(Node head){
        Node fast = head;
        Node slow = head;

        while( slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                break;
            }
        }

        if (slow == null || fast.next == null){
            return null;
        }
        slow = head
        while ( slow != fast){
            slow = slow.next;
            fast = fast.next;

        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
