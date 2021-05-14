package ss;

import java.util.TreeMap;

public class q9 {
    public static int[] findRightInterval(int[][] intervals) {
       TreeMap<Integer, Integer> map  = new TreeMap<>();
       for(int i = 0 ; i < intervals.length; i++){
           map.put(intervals[i][0], i);
       }
       int[] ans = new int[intervals.length];
       for(int i = 0 ; i < ans.length; i++){
           Integer key = map.ceilingKey(intervals[i][1]);
           ans[i] = key ==null?-1:map.get(key);
       }
       return ans;
    }
}
