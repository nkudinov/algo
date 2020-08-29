package f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q45 {
   public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
   }
    // Encodes a tree to a single string.
    static  private  void  serializeHelper(TreeNode root, StringBuilder acc){
           if (acc.length()!=0){
               acc.append(",");
           }
           if (root == null) {
               acc.append("null");
           } else {
               acc.append(root.val);
               serializeHelper(root.left, acc);
               serializeHelper(root.right, acc);
           }
    }
    static public  String serialize(TreeNode root) {
       StringBuilder sb = new StringBuilder();
       serializeHelper(root, sb);
       return sb.toString();
    }
    static  private  TreeNode  deserializeHelper(List<String> lst) {
        if (lst.size() == 0){
            return null;
        }
        String e = lst.get(0);
        lst.remove(0);
        if (e.equals("null")){
            return null;
        } else {
           int value = Integer.valueOf(e);
           TreeNode node = new TreeNode(value);
           node.left  = deserializeHelper( lst);
           node.right = deserializeHelper( lst);
           return node;
        }
    }
    // Decodes your encoded data to tree.
    static public TreeNode deserialize(String data) {
       String[] arr = data.split(",");
       return deserializeHelper( new ArrayList<>(Arrays.asList(arr)));
    }
    static public void print(TreeNode root){
       if (root == null){
           System.out.println("null");
       } else {
           System.out.println(root.val);
           print(root.left);
           print(root.right);
       }
    }
    public static void main(String[] args) {

        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(5);
        TreeNode root = new TreeNode(1);
        root.left  = l1;
        root.right = l2;
        print(root);
        String str = serialize(root);
        System.out.println("serialized:"+str);
        TreeNode root2 = deserialize(str);
        print(root2);

    }

}
