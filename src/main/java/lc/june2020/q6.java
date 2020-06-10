package lc.june2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class q6 {
    static public int getIndex(int[][] arr, int[] e){
        int[] empty = new int[] {-1,-1};
        int index  = e[1];
        int h = e[0];
        for(int i=0; i<=index; i++){
          if ( !Arrays.equals(arr[i], empty) && arr[i][0] < h){
              index++;
          }
        }
        return index;
    }
    static public int[][] reconstructQueue(int[][] people) {
       Arrays.sort(people, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               if ( (o1[0]-o2[0]) == 0 ){
                   return o1[1]-o2[1];
               }
               return o1[0]-o2[0];
           }
       });
       int[][] ret = new int[people.length][2];
       for(int i=0;i<ret.length;i++){
           ret[i][0] =-1;
           ret[i][1] =-1;
       }
       for(int[] e:people){
           ret[getIndex(ret, e)] = e;
       }
       return ret;
    }
    static public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> list = new ArrayList();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][2]);
    }
    public static void main(String[] args) {
       int[][] arr = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};


        for(int[] e:reconstructQueue2(arr)){
            System.out.println(Arrays.toString(e));
        }
    }

}
