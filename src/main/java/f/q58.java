package f;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q58 {
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ret = new ArrayList<>();
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 1; i<=n; i++){
                TreeNode node = q.remove();
                if( node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }
                if ( i == n ){
                    ret.add(node.val);
                }
            }
        }
        return ret;
    }
}
