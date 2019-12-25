package gci;

import java.util.Arrays;
import java.util.Random;

public class HLL {

    int [] set ;

    public HLL() {
        set = new int[256];
    }

    private int getBucket(int x){
      return x&0xFF;
    }

    private byte getZerosNum(int x){
        x = x >> 9;
        byte ret = 0;
        for(int i =0; i< 20;i++){
            if ( (x&0x1) == 0)
                ret++;
            else
               break;
            x = x >> 1;
        }
        return ret;
    }

    public void add(int x){
       int bucket  = getBucket(x);
       byte zeros  = getZerosNum(x);
       set[bucket] = Math.max( set[bucket], zeros);
    }

    public Long aproxCount(){
        double sum = 0;
        for(int i=0;i < set.length; i++)
            sum += Math.pow(2,-1*set[i]);
        return  Math.round(0.7182725932495459*1/sum*set.length*set.length);
    }

    public static void main(String[] args) {

        HLL hll = new HLL();
        Random rand = new Random();
        for( int i=0; i < 20_000_000; i++)
             hll.add( rand.nextInt());
        System.out.println( hll.aproxCount());
        System.out.println( Arrays.toString(hll.set));
    }

}
