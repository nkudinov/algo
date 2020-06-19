package lc.june2020;

public class q17 {
    static public boolean isClosed(int i,int j,char[][] board){
       return false;
    }
    public void solve(char[][] board) {
       for (int i =1; i < board.length/2;i++){
         for(int j=0;j<board[0].length;j++){
             System.out.print(board[i][j]);
         }
       }
    }

    public static void main(String[] args) {
      int[][] board = new int[][]{{1,1},{2,2}};
    }
}
