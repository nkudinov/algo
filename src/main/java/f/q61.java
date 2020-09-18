package f;

import java.util.*;

public class q61 {
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);

         Map<Integer,List<Integer>> table = new HashMap<>();

         Map<TreeNode,Integer> positions = new HashMap<>();
         int minPosition = 0;
         positions.put(root, minPosition);


         while( !q.isEmpty()){
             TreeNode node = q.poll();
             int position  = positions.get(node);

             if (table.containsKey(position)){
                 table.get(position).add(node.val);
             } else {
                 table.put(position, new ArrayList<>(Arrays.asList(node.val)));
             }

             if( node.left != null){
                 q.add(node.left);
                 positions.put(node.left, position -1 );
             }

             if ( node.right != null ){
                 q.add(node.right);
                 positions.put(node.right, position +1);
             }

             minPosition = Math.min(minPosition, position);
         }
         List<List<Integer>> ret = new ArrayList<>();

         while (table.containsKey(minPosition)){
             ret.add(table.get(minPosition));
             minPosition++;
         }

         return ret;
    }
}
