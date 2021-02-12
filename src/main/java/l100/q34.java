package l100;

import java.util.*;

public class q34 {

        static class Node {
            int value;
            List<Node> out;
            Node(int val){
                this.value = val;
                this.out = new ArrayList<>();
            }
        }
        static public int height(int start, int[][] edges){
            Map<Integer, Node> g = new HashMap();
            for(int[] pair:edges){
                Node node1 = getOrCreateNode(g, pair[0]);
                Node node2 = getOrCreateNode(g, pair[1]);
                if ( pair[0] == start){
                    node1.out.add(node2);
                } else if (pair[1] == start){
                    node2.out.add(node1);
                }  else {
                    node1.out.add(node2);
                    node2.out.add(node1);
                }
            }
            Queue<Node> q = new LinkedList<>();
            q.add(g.get(start));
            int level  = 0;
            Set<Node> visited = new HashSet<>();
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 1 ; i <= size; i++){
                    Node node = q.poll();
                    visited.add(node);
                    for(Node n: node.out){
                        if( !visited.contains(n)){
                            q.add(n);
                        }
                    }
                }
                level++;
            }
            return level;
        }
        static public Node getOrCreateNode(Map<Integer, Node> g, Integer x){
            if (!g.containsKey(x)){
                g.put(x, new Node(x));
            }
              return g.get(x);
        }
        static public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> lst = new ArrayList<>();

            int minHeight = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                int h = height(i, edges);
                lst.add(h);
                minHeight = Math.min(minHeight, h);
            }
            List<Integer> ans = new ArrayList();
            for(int i = 0; i < n; i++){
                if(lst.get(i) == minHeight){
                    ans.add(i);
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,0},{1,2},{1,3}};
        for(int n:findMinHeightTrees(4,edges)){
            System.out.println(n);
        }
    }

}
