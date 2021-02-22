package l100;

import java.util.concurrent.atomic.AtomicInteger;

public class q41 {
    static void print(int[][] obstacleGrid){
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
        System.out.println("-----");
        for(int i  = 0; i < N ;i++){
            for(int j = 0 ; j < M; j++){
                System.out.print(obstacleGrid[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void helper(int row, int col , int[][] obstacleGrid, AtomicInteger counter){

        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
        if ( row == N -1 && col == M-1 ){
            counter.set( counter.get()+1);
            return;
        }
        if (!( row == 0 && col == 0)){
            obstacleGrid[row][col] =2;
        }
        print(obstacleGrid);
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir:directions){
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >=0 && r < N  && c >= 0 && c < M && obstacleGrid[r][c] == 0){

                helper( r, c, obstacleGrid, counter);
            }
        }
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[N-1][M-1] == 1){
            return 0;
        }
        AtomicInteger counter = new AtomicInteger(0);
        helper(0,0, obstacleGrid, counter);
        return counter.get();
    }
    public static void main(String[] args) {

        int[][] arr = new int[][]{{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
