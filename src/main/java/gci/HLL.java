package gci;

import java.util.Random;

public class HLL {
    int [] set ;
    public HLL() {
      set = new int[4];
    }

    public void add(Object o ){

    }
    public int aproxCount(){
        return 0;
    }
    public static void main(String[] args) {

        HLL hll = new HLL();
        Random rand = new Random();
        for(int i=0; i< 678001;i++)
            hll.add(rand.nextInt());
        System.out.println(hll.aproxCount());
    }
}
