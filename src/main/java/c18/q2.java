package c18;

import java.util.Arrays;
import java.util.Random;

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
    static public void shuffle(int[] arr){
      for(int i = 1; i<arr.length; i++){
          int index = rnd.nextInt(i);
          int tmp = arr[index];
          arr[index] = arr[i];
          arr[i] = tmp;
      }
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
            shuffle(cards);
            for(int j = 0; j < M; j++){
                hits[j][getIndexByValue(j, cards)] +=1;
            }
        }

        for(int[] e:hits){
            double[] arr = new double[e.length];
            for(int i=0;i<e.length;i++){
                arr[i] = Math.round(e[i]*1.0/N*100.0)/100.0;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
