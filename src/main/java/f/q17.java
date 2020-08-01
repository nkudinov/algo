package f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q17 {
    static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    static int[] findPositions(int[] arr, int x) {

        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            q.add(new Pair(arr[i],i));
        }
        int index = 0;
        int[] ret = new int[x];
        for(int i = 1; i <= x; i++){
            int j = 1;
            Queue<Pair> tmp = new LinkedList<>();
            Pair max = q.peek();
            while ( j <= x && !q.isEmpty()){
                Pair elm = q.remove();
                if (elm.value > max.value){
                    max = elm;
                }
                tmp.add(elm);
                j++;
            }
            while (!tmp.isEmpty()){
               Pair elm = tmp.remove();
               if (elm.index != max.index){
                   q.add(new Pair(elm.value == 0?0:elm.value-1, elm.index));
               }
            }
            ret[index++] = max.index+1;
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 2, 3, 4, 5};
        System.out.println(Arrays.toString(findPositions(arr, 5)));
    }

}
