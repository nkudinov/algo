package am;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q33 {
    public static int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, int[]> map = new HashMap<>(256);
        for(int i = 1; i <= N; i++) {

           int key = (cells[0])|(cells[1]<<1)|(cells[2]<<2)|(cells[3]<<3)|(cells[4]<<4)|(cells[5]<<5)|(cells[6]<<6)|(cells[7]<<7);

           if (!map.containsKey(key)){

               int c0 = cells[0];
               int c1 = cells[1];
               int c2 = cells[2];
               int c3 = cells[3];
               int c4 = cells[4];
               int c5 = cells[5];
               int c6 = cells[6];
               int c7 = cells[7];

               int[] next = new int[8];
               next[0] = 0;
               next[1] = (c0^c2)== 0 ? 1 : 0;
               next[2] = (c1^c3)== 0 ? 1 : 0;
               next[3] = (c2^c4)== 0 ? 1 : 0;
               next[4] = (c3^c5)== 0 ? 1 : 0;
               next[5] = (c4^c6)== 0 ? 1 : 0;
               next[6] = (c5^c7)== 0 ? 1 : 0;
               next[7] = 0;
               map.put( key, next);
           }
           cells = map.get(key);
        }
        return cells;
    }
    public static void main(String[] args) {
        int [] arr = new int[]{0,1,0,1,1,0,0,1};
        int n = 1_000_000_000;
        long time0 = System.currentTimeMillis();
        System.out.println(Arrays.toString(prisonAfterNDays(arr, n)));
        long time1 = System.currentTimeMillis();
        System.out.println( (time1-time0)/1000);
        /*
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
         */
    }

}
