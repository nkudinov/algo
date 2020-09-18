package f;

import java.util.concurrent.atomic.AtomicInteger;

public class q57 {
  public static class TreeNode {
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
    static int max_sum = Integer.MIN_VALUE;
    static public int helper(TreeNode root){
        if ( root == null ){
            return Integer.MIN_VALUE;
        }
        int lSum  = Math.max(helper(root.left),0);
        int rSum  = Math.max(helper(root.right),0);
        int r1 = root.val + lSum + rSum;
        max_sum = Math.max( r1, max_sum);
        int r2 = root.val + Math.max(lSum, rSum);
        return r2;
    }
    static public int maxPathSum(TreeNode root) {
        helper(root);
        return  max_sum;
    }
    public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
       TreeNode left = new TreeNode(2);
       TreeNode right = new TreeNode(3);
       root.left = left;
       root.right = right;
       System.out.println(maxPathSum(root));
    }


}
