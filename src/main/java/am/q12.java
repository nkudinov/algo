package am;

import java.util.*;

public class q12 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0){
            return 0;
        }
        if ( intervals.length == 1){
            return 1;
        }
        int ans = 1;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b) -> a[1] - b[1]);
        for(int[]  interval : intervals){
            if (q.isEmpty()){
                q.add(interval);
            } else {
                int[] stg = q.peek();
                if (stg[1] <= interval[0]){
                    q.poll();
                    q.add(new int[]{stg[0], interval[1]});
                } else {
                    q.add(interval);
                }
            }
        }
        return q.size();
    }
    public static void main(String[] args) {

    }
}
