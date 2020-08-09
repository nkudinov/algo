package lc.aug2020;

public class d8 {
      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) {
              this.val = val;
          }
          TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
       }
    }
    static public int countPath(TreeNode root, int sum){
         if (root == null ){
            return 0;
         }

         int curr = 0;

         if (root.val == sum ){
             curr++;
         }
         return curr + countPath( root.left,sum - root.val) + countPath( root.right,sum - root.val);
    }
    static public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        return countPath( root, sum) + pathSum(root.left,sum) + pathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(8,null,null);
        TreeNode l1 = new TreeNode(8,null,null);
        TreeNode root = new TreeNode(8,l1,r1);
        System.out.println(pathSum(root,8));
    }
}
