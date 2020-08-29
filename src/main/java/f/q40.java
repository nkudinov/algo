package f;

public class q40 {
     static class TreeNode {
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
    public TreeNode helper(TreeNode root, TreeNode append){
        if(root==null) return append;
        helper(root.right, append);
        if (root.right == null) root.right = append;
        helper(root.left, root.right);
        if (root.left != null) root.right = root.left;
        root.left = null;
        return root.right;
    }
    public void flatten(TreeNode root) {
           if ( root == null){
               return;
           }
           root = helper(root, null);
    }
}
