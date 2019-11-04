package c2;

public class q7 {

    static public boolean isPalindrome(Node<Integer> head){
       Node<Integer> r = reverse(head,null);
       Node<Integer> c = head;
       while(c != null && r != null){
           if (c.data!=r.data){
               return false;
           }
           c = c.next;
           r = r.next;
       }
       return true;
    }
    static public Node reverse(Node<Integer> head, Node<Integer> acc){
        if ( head == null ){
            return acc;
        }else {
            Node<Integer> copy = new Node<>(head.data);
            copy.next = acc;
            return reverse(head.next, copy);
         }
    }

    public static void main(String[] args) {
        Node<Integer> l1 = new Node<>(0);
        l1.add(1).add(2).add(1);
        System.out.println(isPalindrome(l1));

    }

}
