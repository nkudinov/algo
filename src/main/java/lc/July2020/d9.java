package lc.July2020;

import java.util.*;

public class d9 {
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
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> lvl = new ArrayList<>();
        while(q.size()!=0){
            int n = q.size();
            lvl.add(n);
            for(int i=1; i<=n; i++){
                TreeNode e = q.remove();
                if ( e !=null ) {
                  if (e.left!=null || e.right!=null) {
                      q.add(e.left);
                      q.add(e.right);
                  }
                }
            }
        }
        return Collections.max(lvl);
    }

    public static void main(String[] args) {
        TreeNode l_l_1 = new TreeNode(5,null,null);
        TreeNode l_l_2 = new TreeNode(3,null,null);
        TreeNode l_1 = new TreeNode(3,l_l_1,l_l_2);


        TreeNode root = new TreeNode(1, l_1,null);

        System.out.println(widthOfBinaryTree( root));
    }

}
