package l100;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class q53 {
    public static int longestConsecutive(int[] nums) {

        int N = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(nums.length);
        for(int i = 0; i < N; i++){
            int x = nums[i];
            if (map.containsKey(x-1)){
                ds.union(i, map.get(x-1));
            }
            if (map.containsKey(x+1)){
                ds.union(i, map.get(x+1));
            }
            map.put(nums[i],i);
        }
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i = 0; i < N; i++){
            int parent = ds.find(i);
            cnt.merge(parent, 1, (a,b) -> a+b);
        }
        return Collections.max(cnt.values());
    }

static class DisjointSet {
    int[] parent;

    DisjointSet(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    void union(int i, int j) {
        int parent1 = find(i);
        int parent2 = find(j);
        if (parent1 != parent2) {
            parent[parent1] = parent2;
        }
    }

    int find(int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent[i]);
    }

}
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println( longestConsecutive(nums));
    }

}
