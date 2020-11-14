package am;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q10 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if ( root == null ){
                return ans;
            }
            q.add(root);
            while(!q.isEmpty()){
                int level = ans.size();
                LinkedList<Integer> list = new LinkedList<>();
                int n = q.size();
                for(int i = 1; i <= n; i++){
                    TreeNode node = q.poll();
                    if (node.left!=null) {
                        q.add(node.left);
                    }
                    if (node.right != null){
                        q.add(node.right);
                    }
                    if (level %2  == 1) {
                        list.addFirst(node.val);
                    } else {
                        list.addLast(node.val);
                    }
                }
                ans.add(list);
            }
            return ans;
    }
    public static void main(String[] args) {

    }
}
