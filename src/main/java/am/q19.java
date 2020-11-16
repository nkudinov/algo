package am;

public class q19 {
    public static boolean exists(char[][] board,int r, int c, int prevR, int prevC, String word, String curr){
        if ( word.equals(curr)) {
            return true;
        } else if ( r < 0 || c < 0 ){
            return false;
        } else if ( r >= board.length || c >= board[0].length ){
            return false;
        }
        curr  = curr + board[r][c];
        if( !word.startsWith(curr)){
            return false;
        }
        System.out.println(curr);
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; d++) {
           if (!(r  + rowOffsets[d] == prevR && c + colOffsets[d] == prevC)){
               if ( exists(board, r + rowOffsets[d], c + colOffsets[d], r, c, word, curr)){
                   return true;
               }
           }
        }
        return false;
    }
    public static boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        for(int r = 0; r < ROWS ; r++){
            for(int c = 0; c < COLS; c++){
                if ( exists( board, r, c, r, c, word, "")){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] arr = new char[][]{{'A','B','C','E'},
                                    {'S','F','C','S'},
                                    {'A','D','E','E'}};
        System.out.println(exist( arr, "ABCCED"));
    }
}
