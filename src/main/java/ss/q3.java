package ss;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class q3 {
    private static String makeString(int x, int y){
        return ""+x+"."+y;
    }
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ sx, sy});
        while(!q.isEmpty() ){
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            if (x == tx && y == ty){
                return true;
            }
            if( x+y <= tx){
                q.add( new int[]{x+y,y});
            }
            if ( x+y <= ty ){
                q.add( new int[]{x, x+y});
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //35
        //13
        //455955547
        //420098884
        System.out.println(reachingPoints(35, 13,455955547, 420098884));
    }
}
