package am;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q9{
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if ( root == null ){
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()){
            int level = ans.size();
            ans.add(new ArrayList<>());
            int n = q.size();
            for(int i = 1; i <= n; i++){
                TreeNode node = q.poll();
                if (node.left!=null) {
                    q.add(node.left);
                }
                if (node.right != null){
                    q.add(node.right);
                }
                ans.get(level).add(node.val);
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
