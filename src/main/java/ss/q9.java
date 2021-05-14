package ss;

import java.util.Arrays;
import java.util.TreeMap;

public class q9 {
    public static int[] findRightInterval_1(int[][] intervals) {
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
    private static int search(int[][] arr, int t){
        // need to look for a value >=target
        int l = 0;
        int r = arr.length-1;
        // [1,2]
        while( l <= r){
            int m = l + ( r - l)/2;
            if (arr[m][0] == t){
                return arr[m][1];
            } else if ( arr[m][0] < t){
                l = m+1;
            } else {
                r = m-1;
            }
        }
        if (l > arr.length-1){
            return -1;
        }
        return arr[l][1];
    }
    public static int[] findRightInterval(int[][] intervals) {
        int[][] tmp = new int[intervals.length][];
        for(int i = 0 ; i < intervals.length; i++){
            tmp[i]    = intervals[i].clone();
            tmp[i][1] = i;
        }
        Arrays.sort(tmp, (a,b) -> a[0] - b[0]);
        int[] ans = new int[intervals.length];
        for(int i = 0 ; i < ans.length; i++){
           ans[i] = search( tmp, intervals[i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        //[[3,4],[2,3],[1,2]]
        int[][] arr = new int[] [] {new int[]{3,4}, new int [] {2,3}, new int []{1,2}};
        System.out.println( Arrays.toString(findRightInterval(arr)));
    }
}
