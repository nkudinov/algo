package f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q23 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Query {
        int u;
        char c;
        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    static int query( Node root, Query query, String s, boolean checking){
        if (root == null){
            return 0;
        }
        if (root.val  == query.u){
            checking = true;
        }
        int ret = 0;
        for(Node n:root.children){
            ret += query( n, query, s, checking);
        }
        if (checking){
           char ch =  s.charAt(root.val-1);
           if ( ch == query.c){
               return ret+1;
           }
           return ret;
        }
        return ret;

    }
    static int[] countOfNodes(Node root, ArrayList<Query> queries, String s){
       List<Integer> tmp = new ArrayList<>();
       for(Query q: queries){
           tmp.add(query( root, q, s, false));
       }
       int[] ret = new int[tmp.size()];
       for(int i = 0; i < ret.length; i++){
           ret[i] = tmp.get(i);
       }
       return ret;
    }
    public static void main(String[] args) {
        int n_2 = 7, q_2 = 3;
        String s_2 = "abaacab";
        Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));
        int[] output_2 = countOfNodes(root_2, queries_2, s_2);
        System.out.println(Arrays.toString(output_2));
    }

}

