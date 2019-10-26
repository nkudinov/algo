package c1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class q7 {
    public static void setZeros(int[][] arr){
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i = 0; i < arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(Integer i:rows){
            for (int j =0 ;j < arr[i].length; j++){
                arr[i][j] = 0;
            }
        }
        for(Integer j:cols){
            for(int i = 0; i < arr.length; i++){
                arr[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
