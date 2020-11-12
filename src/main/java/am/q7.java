package am;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class q7 {

    Map<Integer,Integer> f;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public q7() {
        f = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        f.merge(x, 1, (a,b) -> a + b);
        int freq = f.get(x);
        if ( freq > maxFreq){
            maxFreq = freq;
        }

        group.putIfAbsent(freq, new Stack<Integer>());
        group.get(freq).add(x);

    }

    public int pop() {
        int x = group.get(maxFreq).pop();
        f.merge(x, -1, ( a,b) -> a + b );
        if (group.get( maxFreq).size() == 0)
            maxFreq--;
        return x;
    }
    public static void main(String[] args) {
        q7 q = new q7();
        int[] e = new int[]{5, 7, 5, 7, 4, 5};
        for(int x:e){
            q.push(x);
        }
        System.out.println(q.pop());
        System.out.println(q.pop());
    }

}
