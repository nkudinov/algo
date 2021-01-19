package l100;

import javafx.util.Pair;

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
    public Pair<TreeNode,Integer> helper(TreeNode root, int d){
        if (root == null ){
            return new Pair<>(null, d);
        }
        Pair<TreeNode,Integer> l = helper(root.left,d +1);
        Pair<TreeNode,Integer> r = helper(root.right,d +1);

        if (l.getValue() == r.getValue()) {
            return new Pair<>(root, l.getValue());
        } else {
            return  l.getValue() > r.getValue() ? l : r;
        }

    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair<TreeNode,Integer> pair = helper(root, 0);
        return pair.getKey();
    }

    public static void main(String[] args) {

    }
}
