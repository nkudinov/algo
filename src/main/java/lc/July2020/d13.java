package lc.July2020;

import java.util.LinkedList;
import java.util.Queue;

public class d13 {
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

    }
    static public boolean compare(TreeNode n1,TreeNode n2){
        // could not be null
        if (n1.left == null && n2.left!=null){
            return false;
        } else  if( n1.left!=null && n2.left==null){
            return false;
        } else if (n1.right == null && n2.right!=null){
            return false;
        } else  if( n1.right !=null && n2.right==null){
            return false;
        }
        return true;
    }
    static public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        if (p!=null){
            q1.add(p);
        }
        if (q!=null){
            q2.add(q);
        }
        while ( !q1.isEmpty() && !q2.isEmpty()){
            int n1 = q1.size();
            int n2 = q2.size();
            if (n1 != n2){
                return false;
            }
            for(int i = 1; i <=n1; i++){
                TreeNode t1 = q1.remove();
                TreeNode t2 = q2.remove();
                if (t1.val!=t2.val){
                    return false;
                }
                if (!compare(t1,t2)){
                    return false;
                }
                if (t1.left!=null){
                    q1.add(t1.left);
                }
                if (t1.right!=null){
                    q1.add(t1.right);
                }
                if (t2.left!=null){
                    q2.add(t2.left);
                }
                if (t2.right!=null){
                    q2.add(t2.right);
                }
            }

        }
        return q1.isEmpty() && q2.isEmpty();
    }
    public static void main(String[] args) {

    }

}
