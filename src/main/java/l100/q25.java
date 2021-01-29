package l100;

import java.util.Arrays;

public class q25 {

    static class TreeNode {
       int val;
        TreeNode left;
        TreeNode rigth;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static void inOrder(TreeNode root){
        if(root == null){
           return;
        }
        System.out.print(root.val+" ");
        inOrder(root.left);
        inOrder(root.rigth);
    }
    static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.rigth);
        System.out.print(root.val+" ");
    }
    static TreeNode  helper(int[] pre , int[] post ){
        int N = pre.length;
        if (N == 0 ){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if( N == 1){
            return root;
        }
        int end  = 0;
        for(int j = 0; j < post.length; j++){
            if (post[j] == pre[1]){
                end = j+1;
            }
        }
        root.left  = helper( Arrays.copyOfRange(pre, 1, end+1), Arrays.copyOfRange(post, 0,end));
        root.rigth = helper( Arrays.copyOfRange(pre, end+1, N), Arrays.copyOfRange(post, end,N-1));
        return root;
    }
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper( pre , post);
    }
    public static void main(String[] args) {
        int[] pre  = new int[] {1, 2,4,5, 3,6,7};
        int[] post = new int[] {4,5,2 ,6,7,3 ,1};
        inOrder(constructFromPrePost(pre, post));

    }
}
