package g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class q11 {
    static public void add(List<int[]> list, int[] newInterval){
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
    static public int[][] merge(int[][] intervals) {
        int i = 0;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        while (i < intervals.length){
            add(list, intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{new int[] {1,4}, new int[]{0,4}};
        int[][] res = merge(arr);
        for(int[] e: res){
            System.out.println(Arrays.toString(e));
        }
    }
}
