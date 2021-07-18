package m;

import java.lang.reflect.Array;
import java.util.*;

public class q3 {
    public static int solution(int N, int[] A, int[] B) {
        Integer[] weight = new Integer[N];
        Map<Integer,Integer> inDegree = new HashMap<>();
        for(int i = 0; i < N; i++){
            weight[i] = i;
            inDegree.put(i,0);
        }
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] -1;
            B[i] = B[i] -1;
            adjList.putIfAbsent(A[i],new ArrayList<>());
            adjList.get(A[i]).add(B[i]);

            adjList.putIfAbsent(B[i],new ArrayList<>());
            adjList.get(B[i]).add(A[i]);

            inDegree.merge(A[i],1, (a,b) -> a+b);
            inDegree.merge(B[i],1, (a,b) -> a+b);
        }
        Arrays.sort( weight, (a,b) -> inDegree.get(a) - inDegree.get(b));
        System.out.println(Arrays.toString(weight));
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < N; i++){
            if (!seen.contains(i)){
                q.add(i);
                while(!q.isEmpty()){
                  int node = q.poll();
                  seen.add(i);
                  if ( adjList.getOrDefault(node, new ArrayList<>()).size()!=0){
                      ans += weight[node] + 1;
                  }

                  for(Integer child: adjList.getOrDefault(node, new ArrayList<>())){
                      if (!seen.contains(child)){
                          q.add(child);
                          seen.add(child);
                          ans += weight[child] + 1;
                      }
                  }
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int N = 5;
        int[] A = new int[]{2,2,1,2};
        int[] B = new int[]{1,3,4,4};
        System.out.println(solution(N,A,B));

        N = 3;
        A = new int[]{1};
        B = new int[]{3};
        System.out.println(solution(N,A,B));
    }
}
