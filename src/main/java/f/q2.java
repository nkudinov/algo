package f;

import scala.Int;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q2 {
    static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;
        TreeNode(int value, TreeNode left, TreeNode right){
            this.value = value;
            this.left  = left;
            this.right = right;
        }
    }
    static List<Double> avg(TreeNode root){
        if (root == null){
            return null;
        }
        List<Double> ret = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int sum = 0;
            for(int i = 1; i <= n; i++){
                TreeNode node = q.remove();
                sum += node.value;
                if ( node.left != null){
                    q.add( node.left);
                }
                if( node.right != null ){
                    q.add( node.right);
                }
            }
            ret.add(sum*1.0/n);
        }
        return ret;
    }
    private static void collect(TreeNode node, List<List<Integer>> items, int level){
        if (node == null){
            return;
        }
        if (level >= items.size()){
            items.add(new ArrayList<Integer>());
        }

        List<Integer> levelItems = items.get(level);
        levelItems.add(node.value);
        collect(node.left, items, level + 1);
        collect(node.right, items, level + 1);
    }
    public static List<Double> avg2(TreeNode root){
      List<List<Integer>> items = new ArrayList<>();
      collect( root, items, 0 );
      List<Double> ret = new ArrayList<>();
      for(List<Integer> levelItems:items){
          int sum = 0;
          for(Integer e:levelItems){
              sum += e;
          }
          ret.add(sum*1.0/levelItems.size());
      }
      return ret;
    }
    public static void main(String[] args) {
        TreeNode rl = new TreeNode(7,null,null);
        TreeNode rr = new TreeNode(9,null,null);
        TreeNode root = new TreeNode(4,rl,rr);
        for(double v:avg(root)){
            System.out.println(v);
        }
        for(double v:avg2(root)){
            System.out.println(v);
        }
    }
}
