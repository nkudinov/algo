package gci;

import java.util.Arrays;
import java.util.Random;

//Linear Probabilistic Counter
public class LPC {
    private byte[] set;

    public LPC(int capacity) {
        set = new byte[capacity];
    }
    public void add(Object o ){
       set[Math.abs(o.hashCode()%(set.length-1))] = 1;
    }
    public int aproxCount(){
       int zeroCount =0;
       for(int i=0; i < set.length;i++){
          if (set[i] == 0)
              zeroCount++;
       }
       return  -1*(int)(set.length*(Math.log((zeroCount*1.0)/set.length)/Math.log(2)));
    }
    public void print(){
        System.out.println(Arrays.toString(set));
    }

    public static void main(String[] args) {
        //DOES NOT WORK . SO I HAVE A BUG
        LPC lpc = new LPC(8000);
        Random rand = new Random();
        for(int i=0; i< 678001;i++)
            lpc.add(rand.nextInt());
        System.out.println(lpc.aproxCount());
    }
}
