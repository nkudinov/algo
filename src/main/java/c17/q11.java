package c17;

import scala.util.Random;

import java.util.HashMap;
import java.util.Map;

public class q11 {
   static Random r5 = new Random();

   public static int rand5(){
       return r5.nextInt(5);
   }
    public static int rand7(){
       int ret =0;
       while(true){
           ret = 5*rand5();
           if (ret < 21){
               break;
           }
       }
       return ret%7;
    }

    public static void main(String[] args) {
        int N = 10000000;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< N ;i++){
            map.merge(rand7(), 1, Integer::sum);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            System.out.println(e.getKey()+" = "+e.getValue()*1.0/N);
        }
    }
}
