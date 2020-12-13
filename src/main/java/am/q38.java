package am;

import java.util.*;

public class q38 {
    static class Node {
        int inCount;
        List<Node> out;
        Node(){
            inCount = 0;
            out = new ArrayList<>();
        }
    }
    private static Node getOrCreate(Map<Integer, Node> graph, int num){
        if (graph.containsKey(num)){
            return graph.get(num);
        } else {
            graph.put(num, new Node());
            return graph.get(num);
        }
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0){
            return true;
        }
        Map<Integer, Node> graph = new HashMap<>();
        for(int[] pair: prerequisites){
            Node prev = getOrCreate(graph, pair[0]);
            Node next = getOrCreate(graph, pair[1]);
            prev.out.add(next);
            next.inCount += 1;
        }
        Queue<Node> q = new LinkedList<>();
        int nodeCount = prerequisites.length;
        for(Integer key:graph.keySet()){
            if (graph.get(key).inCount == 0){
                q.add(graph.get(key));
            }
        }
        int processedCoutn  = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(Node next:node.out){
                next.inCount -=1;
                if ( next.inCount == 0){
                    q.add(next);
                }
                processedCoutn++;
            }
        }
        if (nodeCount != processedCoutn){
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        //2
        //[[1,0],[0,1]]
        int[][] dep = new int[][]{{1,0}};
        System.out.println(canFinish(2, dep));
    }

}
