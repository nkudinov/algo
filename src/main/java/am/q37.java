package am;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class q37 {
    public static int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        int freshCount = 0;
        for( int r = 0 ; r < ROWS; r++){
            for( int c = 0; c < COLS; c++){
                if (grid[r][c] == 2){
                    q.add(new Pair<Integer,Integer>(r, c));
                } else if (grid[r][c] == 1){
                    freshCount++;
                }
            }
        }
        int ans = 0;
        int[] rowDirection = new int[]{-1, 1, 0, 0};
        int[] colDirection = new int[]{ 0, 0, 1,-1};
        while(!q.isEmpty()){
            int n = q.size();
            boolean foundNew = false;
            for(int i = 1; i <= n ; i++){
                Pair<Integer, Integer> pair = q.poll();
                int r = pair.getKey();
                int c = pair.getValue();
                for(int j = 0; j <4; j++){
                    int newRow = r + rowDirection[j];
                    int newCol = c + colDirection[j];
                    if (newRow >=0 && newRow < ROWS && newCol >=0 && newCol < COLS && grid[newRow][newCol] == 1){
                        q.add(new Pair<>(newRow, newCol));
                        grid[newRow][newCol] = 2;
                        foundNew = true;
                        freshCount--;
                    }
                }
            }
            if (foundNew){
                ans++;
            }
        }
        return freshCount==0?ans:-1;
    }

    public static void main(String[] args) {
       // int[][] arr = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        int[][] arr = new int[][]{{1},{2}};
        System.out.println(orangesRotting(arr));

    }
}
