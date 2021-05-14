package ss;

import javafx.util.Pair;

import java.util.PriorityQueue;
import java.util.Queue;

public class q8 {
    public static String longestDiverseString(int a, int b, int c) {
        Queue<Pair<Integer,Character>> q = new PriorityQueue<>( (x1, x2) -> x2.getKey() - x1.getKey());
        if ( a > 0) {
            q.add(new Pair<>(a, 'a'));
        }
        if ( b > 0 ) {
            q.add(new Pair<>(b, 'b'));
        }
        if ( c > 0) {
            q.add(new Pair<>(c, 'c'));
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Pair<Integer,Character> pair1 = q.poll();
            char ch1 = pair1.getValue();
            int  n1  = pair1.getKey();
            if (sb.length()!= 0 && sb.charAt(sb.length()-1) == ch1){
                break;
            }
            if ( n1 >= 2){
                sb.append(ch1);
                sb.append(ch1);
                n1 -=2;
            } else {
                sb.append(ch1);
                n1 -=1;
            }
            if (!q.isEmpty()) {
                Pair<Integer,Character> pair2 = q.poll();
                char ch2 = pair2.getValue();
                int  n2  = pair2.getKey();
                if (n2 >=2 && n1 < n2){
                    sb.append(ch2);
                    sb.append(ch2);
                    n2 -=2;
                } else {
                   sb.append(ch2);
                   n2 -=1;
                }
                if (n2 > 0){
                    q.add(new Pair<>(n2,ch2));
                }
            }
            if (n1 > 0 ){
                q.add(new Pair<>(n1,ch1));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(0,8,11));

    }

}
