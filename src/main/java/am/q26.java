package am;

public class q26 {
    public int maximalSquare(char[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int[][] dp = new int[ROWS+1][COLS+1];
        int maxSquare  = 0 ;
        for(int r = 1 ; r <= ROWS; r++){
            for(int c = 1;  c <= COLS ; c++){
                if (matrix[r-1][c-1] == 1){
                    dp[r][c] = Math.min( Math.min( dp[r][c-1],dp[r-1][c] ), dp[r-1][c-1])+1;
                    maxSquare =  Math.max(maxSquare, dp[r][c]);
                }
            }
        }
        return maxSquare*maxSquare;
    }

    public static void main(String[] args) {
        //[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]

    }
}
