package f;

import java.util.Random;
import java.util.TreeMap;

public class q74 {
    int total = 0;
    TreeMap<Integer, Integer> map= new TreeMap<>();
    Random rnd= new Random();
    public q74(int[] w) {
        for (int i = 0; i < w.length; i++){
            total += w[i];
            map.put( total, i);
        }
    }

    public int pickIndex() {

        return map.higherEntry(rnd.nextInt(total)).getValue();
    }

    public static void main(String[] args) {

    }

}
