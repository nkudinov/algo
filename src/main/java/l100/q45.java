package l100;

import java.util.Arrays;

public class q45 {
    static class DisjoinSet {
        int[] arr;
        DisjoinSet(int n){
            arr = new int[n];
            Arrays.fill(arr, -1);
        }
        public int find(int i){
            if (arr[i] == -1){
                return i;
            }
            return find(arr[i]);
        }
        public boolean union(int a, int b){
            int p1 = find(a-1);
            int p2 = find(b-1);
            if (p1 == p2){
                return false;
            }
            arr[p1] = p2;
            return true;
        }
    }
    public static int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        DisjoinSet s = new DisjoinSet(N);
        for(int i = 0; i < N; i++){
            if (!s.union( edges[i][0], edges[i][1])){
                return edges[i];
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
       // int[][] e = new int[][]{{1,2},{1,3},{2,3}};
        int[][] e = new int[][] {{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(findRedundantConnection(e)));
    }

}
