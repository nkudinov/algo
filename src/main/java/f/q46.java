package f;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Stack;

public class q46 {
   static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
     public static class BSTIterator  {
        Stack<TreeNode> stack;
        private void helper(Stack<TreeNode> stack, TreeNode root){
            if( root == null){
                return;
            }
            TreeNode curr = root;
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
        }
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            helper( stack , root);
        }

        /** @return the next smallest number */
        public int next () {
           TreeNode e = stack.pop();
           helper(stack, e.right);
           return e.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext () {
        return stack.size()!=0;
        }
    }
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(15);
        TreeNode r1l = new TreeNode(9);
        TreeNode r1r = new TreeNode(20);
        r1.left = r1l;
        r1.right = r1r;
        TreeNode root = new TreeNode(7);
        root.left  = l1;
        root.right = r1;
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());    // return 3
        System.out.println(iterator.next());    // return 7
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 9
        System.out.println( iterator.hasNext()); // return true
        System.out.println( iterator.next());    // return 15
        System.out.println( iterator.hasNext()); // return true
        System.out.println( iterator.next());    // return 20
        System.out.println( iterator.hasNext()); // return false
    }
}
