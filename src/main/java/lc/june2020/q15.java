package lc.june2020;

public class q15 {
      public class TreeNode {
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
    public TreeNode searchBST(TreeNode root, int val) {
       if (root == null){
           return null;
       }
       if (root.val == val){
           return root;
       } else if (val < root.val ){
           return searchBST(root.left,val);
       }
       return searchBST(root.right,val);
    }
    public static void main(String[] args) {

    }
}
