package ss;

import java.util.*;

public class q2 {

    public static boolean canMeasureWater(int x, int y, int z) {
        if ( x + y < z){
            return false;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        Set<String> visited = new HashSet<>();
        while(!q.isEmpty()){
            int[] e = q.poll();

            int a = e[0];
            int b = e[1];
            if ( a + b == z){
                return true;
            }
            visited.add(""+a+"."+b);
            List<int[]> states = new ArrayList<>();
            states.add(new int[]{a,0});
            states.add(new int[]{a,y});
            states.add(new int[]{0,b});
            states.add(new int[]{x,b});
            states.add(new int[]{ Math.min(a+b,x), a + b < x?0:(b - (x - a))});
            states.add(new int[]{ a + b < y ? 0 : a - (y - b), Math.min(a+b,y)});
            for(int[] state:states){
                if (!visited.contains(""+state[0]+"."+state[1])){
                    q.add(state);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println( canMeasureWater(3,5,4));
    }
}
