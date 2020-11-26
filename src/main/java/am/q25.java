package am;

import javafx.util.Pair;

import java.util.*;

public class q25 {
    static List<String> getIslands(int[][] grid ,int ROWS, int r, int COLS, int c){
        List<String> lst = new ArrayList<>();
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(r, c));
        int cnt = 0;
        lst.add(""+cnt);
       // grid[r][c] = grid[r][c]+2;
        int[][] directions = new int[][]{{-1,-1},{1,0},{0,1},{1,1},{0,-1},{-1,0},{1,-1},{-1,1}};
        while(!q.isEmpty()){
            Pair<Integer,Integer> pair = q.poll();

            for(int i =0 ; i < directions.length ;i++){
                int row = pair.getKey() + directions[i][0];
                int col = pair.getValue() + directions[i][1];
                cnt++;
                if( row >= 0 && row <ROWS && col >=0  && col < COLS && grid[row][col] == 1){
                    q.add(new Pair<>( row, col));
                    grid[row][col] = grid[row][col]+2;
                    lst.add(""+cnt);
                }
            }
        }
        return lst;
    }
    static public int numDistinctIslands(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Set<List<String>> set = new HashSet<>();
        for(int r = 0; r < ROWS; r++){
            for(int c =  0; c < COLS; c++){
                if (grid[r][c] == 1){
                    grid[r][c] = -1;
                    List<String> lst = getIslands(grid, ROWS, r, COLS, c);
                    Collections.sort(lst);
                    set.add(lst);
                }
                print(grid);
            }
        }
        return set.size();
    }
    static void print(int[][] grid){
        for(int[] line:grid){
            System.out.println(Arrays.toString(line));
        }
        System.out.println("----");
    }
    public static void main(String[] args) {
        //[[0,1,0],[1,0,1]]
        //int[][] arr = new int[][] {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        int[][] arr = new int[][] {{0,1,0},{1,0,1}};
        System.out.println(numDistinctIslands(arr));
    }
}
