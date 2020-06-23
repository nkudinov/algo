package lc.june2020;

import java.util.LinkedList;
import java.util.Queue;

public class q23 {
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
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int ret = 0;
        if (root==null){
            return ret;
        }
        q.add(root);

        while(q.size()!=0){
           ret++;
           TreeNode e = q.poll();
           if (e.left!=null){
               q.add(e.left);
           }
           if (e.right!=null){
               q.add(e.right);
           }
        }
        return ret;
    }
}
