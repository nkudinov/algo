package f;

public class q59 {
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
    static public int helper(TreeNode root, int acc){
        if (root == null){
            return acc;
        }
        int l = helper(root.left, acc+1);
        int r = helper(root.right, acc+1);
        return Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
      return helper(root, 1);
    }
}
