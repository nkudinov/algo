package ss;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class q16 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: tasks){
            map.merge(ch , 1 , (a,b) ->  a + b);
        }
        PriorityQueue<Character> q = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(char ch: map.keySet()){
            q.add(ch);
        }
        int ans  = 0;
        while(!q.isEmpty()){
            List<Character> tmp = new ArrayList<>();
            int t = 0;
            for(int i = 1 ; i <= n + 1; i++){
                if (!q.isEmpty()){
                    tmp.add(q.poll());
                    t++;
                }
            }
            for(char ch: tmp){
                if (map.get(ch) > 1){
                    map.merge( ch,-1, (a,b) -> a + b);
                    q.add(ch);
                }
            }
            ans += q.isEmpty()?t:(n+1);

        }
        return ans;
    }
    public static void main(String[] args) {
        int x = leastInterval(new char[]{'A','A','A','B','B','B'},2 );
        System.out.println(x);
    }


}
