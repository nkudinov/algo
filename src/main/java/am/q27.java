package am;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q27 {
    public static int findCircleNum(int[][] a) {
        int ROWS  = a.length;
        int COLS  = a[0].length;
        int count = 0;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if (a[r][c] == 1){
                    Queue<Pair<Integer,Integer>>  q = new LinkedList<>();
                    q.add(new Pair<>( r, c));
                    a[r][c] = a[r][c] * -1;
                    while(!q.isEmpty()){
                        Pair<Integer,Integer> pair = q.poll();
                        int[][] steps = new int[][]{{1,-1},{-1,-1},{1,1},{-1,1},{1,0},{-1,0},{0,1},{0,-1}};
                        for(int j = 0;  j < steps.length; j++){
                            int row = pair.getKey() + steps[j][0];
                            int col = pair.getValue()+ steps[j][1];
                            if ( row >= 0 && row < ROWS && col >= 0 && col < COLS && a[row][col] == 1){
                                q.add(new Pair<>( row, col));
                                a[row][col] = a[row][col] * -1;
                            }
                        }
                    }
                    print(a);
                    count++;
                }
            }
        }
        return count;
    }
    static void print(int[][] grid){
        for(int[] line:grid){
            System.out.println( Arrays.toString(line));
        }
        System.out.println("----");
    }
    public static void main(String[] args) {
        //[[],[],[],[]]
        int[][] arr = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(arr));
    }
}
