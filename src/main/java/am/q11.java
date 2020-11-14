package am;

public class q11 {
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
    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null){
            return true;
        }
        if( l == null || r == null){
            return false;
        }
        return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left) ;

    }
    public boolean isSymmetric(TreeNode root) {
       if (root == null){
           return true;
       }
       return isSymmetric(root.left,root.right);
    }

    public static void main(String[] args) {

    }
}
