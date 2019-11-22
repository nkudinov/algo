package c4;

class Tree {
    Tree left;
    Tree right;
}
public class q1 {

 public  static boolean isBalanced(Tree root){
     if (root == null){
         return true;
     } else {
         return Math.abs( height(root.left) - height(root.right) ) <= 1;
     }
 }
 public static int height(Tree root){
      if (root == null){
          return 0;
      } else {
         int l = height(root.left);
         int r = height(root.right);
         return Math.max(l,r)+1;
      }
 }

    public static void main(String[] args) {
      Tree root  = new Tree();
      root.left  = new Tree();
      root.right = new Tree();
      root.right.right = new Tree();
      root.right.right.right = new Tree();

      System.out.println(isBalanced(root));
    }
}
