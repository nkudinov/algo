package a;

public class q1 {
    static class Node {
        public final int value ;
        public final Node left;
        public final Node righ;

        public Node(int value, Node left, Node righ) {
            this.value = value;
            this.left = left;
            this.righ = righ;
        }
    }
    static public void print(Node root){
      if (root == null){
          return;
      }
      if (root.value % 2 == 1){
          print(root.left);
          System.out.print(","+ root.value);
          print(root.righ);
      } else{
          print(root.righ);
          System.out.print(","+ root.value);
          print(root.left);
      }
    }
    public static void main(String[] args) {
    /*
           10
       5       20
     1   6   15  21

     odd- left to right
     21 20 15 10 1 5 6
     */
     Node ll = new Node(1,null,null);
     Node lr = new Node(6,null,null);
     Node l1 = new Node(5,ll,lr);

     Node rl = new Node(15,null,null);
     Node rr = new Node(21,null,null);
     Node r1 = new Node(20,rl,rr);

     Node root = new Node(10, l1,r1);

     print(root);
    }
}
