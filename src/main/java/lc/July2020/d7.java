package lc.July2020;

public class d7 {
    static public int getPerimeter(int i,int j, int[][] grid){
        if (grid[i][j]==0){
            return 0;
        }
        int ret =0;
        if (i >= 1){
            ret += 1-grid[i-1][j];
        }else {
            ret += 1;
        }
        if(j >= 1){
            ret += 1-grid[i][j-1];
        }else{
            ret +=1;
        }
        if( i + 1< grid.length){
            ret += 1-grid[i+1][j];
        }else {
            ret +=1;
        }
        if( j + 1< grid[i].length){
            ret += 1-grid[i][j+1];
        }else {
            ret +=1;
        }
        return ret;
    }
    static public int islandPerimeter(int[][] grid) {
        int ret =0;
        for(int i = 0 ;i < grid.length; i++){
            for(int j = 0;j < grid[i].length; j++){
                ret += getPerimeter(i,j,grid);
                System.out.print(getPerimeter(i,j,grid)+" ");
            }
            System.out.println("");
        }
        return ret;
    }
    public static void main(String[] args) {
     int[][] arr = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
     System.out.println(islandPerimeter(arr));
    }
}
