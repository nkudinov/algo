package g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q10 {
    static public void add( List<int[]> list, int[] newInterval){
        if (list.size() >= 1){
            int n = list.size();
            int[] lastInterval = list.get(n-1);
            if ( lastInterval[0] <= newInterval[0] && newInterval[0] <= lastInterval[1]){
                list.remove(n-1);
                list.add(new int[] {lastInterval[0], Math.max( newInterval[1], lastInterval[1])} );
            } else {
                list.add(newInterval);
            }
        } else{
            list.add(newInterval);
        }
    }
    static  public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;

        while( i < intervals.length && intervals[i][0] <= newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        add( list, newInterval);
        while( i < intervals.length){
            add( list, intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args) {
        int[][] arr = new int[][] {new int[]{1,3}, new int[] {6,9}};
        int []  ins  = new int[]{2,5};
        int[][] res = insert(arr, ins);
        for(int[] e: res){
            System.out.println(Arrays.toString(e));
        }
    }


}
