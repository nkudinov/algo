package gci;

import java.util.Arrays;
import java.util.Random;

public class HLL {
    byte [] set ;

    public HLL() {
        set = new byte[128];
    }

    private byte getBucket(int x){
       return (byte)( x >>> 24);
    }
    private byte getZeros(int x){
        byte ret = 0;
        for(int i =0; i< 20;i++){
            if ( (x&0x1) == 1)
                ret++;
            else
               break;
            x = x >>1;
        }
        return ret;
    }
    public void add(int x){
       byte bucket = getBucket(x);
       byte zeros  = getZeros(x);
       set[bucket] = (byte) Math.max( set[bucket], zeros);
    }

    public Long aproxCount(){
        double sum = 0;
        for(int i=0;i < set.length;i++)
            sum += Math.pow(2,-1*set[i]);
        return  Math.round(0.7213*set.length*set.length*1/sum);
    }

    public static void main(String[] args) {

        HLL hll = new HLL();
        Random rand = new Random();
        for( int i=0; i < 1_000_000; i++)
             hll.add( rand.nextInt( Integer.MAX_VALUE));
        System.out.println( hll.aproxCount());
        System.out.println(Arrays.toString(hll.set));
    }

}
