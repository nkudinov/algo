package l100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class q54 {
    public int removeStones(int[][] stones) {
        //1 <= stones.length <= 1000
        //0 <= xi, yi <= 104
        DSet ds = new DSet(20000);
        for(int[] stone: stones){
            ds.union( stone[0], stone[1] + 10000);
        }
        Set<Integer> parents = new HashSet<>();
        for(int[] stone: stones){
            parents.add( ds.find(stone[0]));
        }
        return stones.length - parents.size();
    }
    class DSet {
        int[] parents;
        DSet(int n){
            parents = new int[n];
            Arrays.fill(parents, -1);
        }
        void union(int i, int j){
            int parent1 = find(i);
            int parent2 = find(j);
            if (parent1 != parent2){
                parents[parent1] = parent2;
            }
        }
        int find(int i){
            if (parents[i]==-1){
                return i;
            }
            return find(parents[i]);
        }
    }

    public static void main(String[] args) {

    }
}
