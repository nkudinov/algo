package c18;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

public class q2 {
    int[] cards;
    static Random rnd =  new Random();
    q2(int[] cards){
        this.cards = cards;
    }
    static int getIndexByValue(int value, int[] arr){
        for(int i=0;i < arr.length;i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
    /*
      x
      x x
      x x x
      x x x x
      x x x x x
     */
    static public int[] shuffle1(int[] arr){
      int[] ret = new int[arr.length];
      List<Integer> lst = new ArrayList<>();
      for(int i = 0; i < arr.length; i++){
         lst.add(i);
      }
      Random rnd = new Random();
      for(int i = arr.length-1; i>=0;i--){
            int index = rnd.nextInt(i+1);
            ret[i] = arr[lst.remove(index)];
      }
      return ret;
    }
    static public int[] shuffle2(int[] arr){
        int[] ret = Arrays.copyOf(arr, arr.length);

        for(int i = 0; i < ret.length; i++){
            int index = rnd.nextInt(i+1);
            int tmp = ret[index];
            ret[index] = ret[i];
            ret[i] = tmp;
        }
        return ret;
    }
    static public int[] shuffle3(int[] arr){
        int[] ret =  Arrays.copyOf(arr, arr.length);

        for(int i = ret.length-1; i  >= 0; i--){
            int min = i;
            int max = arr.length;
            int index = min + rnd.nextInt(max - min);
            int tmp = ret[index];
            ret[index] = ret[i];
            ret[i] = tmp;
        }
        return ret;
    }
    public static void main(String[] args) {
        int M = 10;
        int[] cards =  new int[M];
        for(int i=0; i< M; i++){
            cards[i]=i;
        }
        System.out.println(Arrays.toString(cards));
        int N = 100000;
        int[][] hits = new int[cards.length][cards.length];
        for(int i =0; i < N; i++){
            int[] tmp = shuffle2(cards);
            for(int j = 0; j < M; j++){
                hits[j][getIndexByValue(j, tmp)] +=1;
            }
        }

        for(int[] e:hits){
            double[] arr = new double[e.length];
            for(int i=0; i<e.length; i++){
                arr[i] = Math.round(e[i]*1.0/N*100.0)/100.0;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
