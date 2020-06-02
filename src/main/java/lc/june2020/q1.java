package lc.june2020;

public class q1 {
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
          public void print(TreeNode root, int indent){
              if (root == null){
                  return;
              }
              print(root.left,indent+1);
              for(int i=0; i<indent;i++)
                  System.out.print(" ");
              System.out.println(root.val);
              print(root.right,indent+1);

          }
      }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right =  tmp;
        return root;
    }
    public static void main(String[] args) {
        TreeNode left11 = new TreeNode(1,null,null);
        TreeNode right11 = new TreeNode(3,null,null);
        TreeNode left1 = new TreeNode(2,left11,right11);
        TreeNode right1 = new TreeNode(7,null,null);
        TreeNode root = new TreeNode(4, left1,right1);
        root.print(root,0);
        TreeNode newRoot = invertTree(root);
        newRoot.print(newRoot,0);
    }
}
