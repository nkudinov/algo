package lc.june2020;

import java.util.Arrays;
import java.util.Comparator;

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
    public static void main(String[] args) {
       int[][] arr = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        for(int[] e:reconstructQueue(arr)){
            System.out.println(Arrays.toString(e));
        }
    }

}
