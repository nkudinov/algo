package lc.July2020;


import java.util.*;

public class d2 {
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

    static public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add( root);
        while(!q.isEmpty()){
           int len = q.size();
           List<Integer> lst = new ArrayList<>();
           for(int i =1; i <= len;i++){
               TreeNode n = q.remove();
               lst.add(n.val);
               if (n.left!=null){
                   q.add( n.left);
               }
               if (n.right!=null){
                   q.add( n.right);
               }
           }
           ret.add(0, lst);
        }
        return ret;
    }
    public static void main(String[] args) {
        TreeNode ll = new TreeNode(1,null,null);
        TreeNode lr = new TreeNode(6,null,null);
        TreeNode l1 = new TreeNode(5,ll,lr);

        TreeNode rl = new TreeNode(15,null,null);
        TreeNode rr = new TreeNode(21,null,null);
        TreeNode r1 = new TreeNode(20,rl,rr);

        TreeNode root = new TreeNode(10, l1,r1);

        System.out.println(levelOrderBottom(root));
    }
}
