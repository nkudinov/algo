package lc.July2020;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class d3 {
    static public int[] prisonAfterNDays(int[] cells, int N) {
        int[] ret = Arrays.copyOf(cells,cells.length);
        int steps = 0;
        if  (N%14 == 0){
            steps = 14;
        } else {
            steps = N%14;
        }

        for(int i = 1; i <= N; i++) {
            int e1 = 1-(ret[0]^ret[2]);
            int e2 = 1-(ret[1]^ret[3]);
            int e3 = 1-(ret[2]^ret[4]);
            int e4 = 1-(ret[3]^ret[5]);
            int e5 = 1-(ret[4]^ret[6]);
            int e6 = 1-(ret[5]^ret[7]);

            ret[0] = 0;
            ret[1] = e1;
            ret[2] = e2;
            ret[3] = e3;
            ret[4] = e4;
            ret[5] = e5;
            ret[6] = e6;
            ret[7] = 0;
        }
        return ret;
    }
    public static void main(String[] args) {
      int[] cells1 = new int[] {1,0,0,1,0,0,1,0};
      int[] cells2 = new int[] {1,0,0,1,0,0,0,1};
      int[] cells3 = new int[] {1,0,1,0,0,0,1,0};
   //   System.out.println(Arrays.toString(prisonAfterNDays(cells1,1000000000)));
      /*
0,0,1,1,1,1,1,0
       */
      //  System.out.println(Arrays.toString(prisonAfterNDays(cells2,826)));
        //0,1,1,0,1,1,1,0
        System.out.println(Arrays.toString(prisonAfterNDays(cells3,826)));
    }
}
