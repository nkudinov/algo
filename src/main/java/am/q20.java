package am;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q20 {
    public static boolean exists(char[][] board,int r, int c, String word, String curr){
        if ( word.equals(curr)) {
            return true;
        } else if ( r < 0 || c < 0 ){
            return false;
        } else if ( r >= board.length || c >= board[0].length ){
            return false;
        }
        char ch = board[r][c];
        curr  = curr + ch;
        if( !word.startsWith(curr)){
            return false;
        }
        board[r][c] ='#';
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; d++) {
            if (exists(board, r + rowOffsets[d], c + colOffsets[d], word, curr)){
                board[r][c] = ch;
                return true;
            }
        }
        board[r][c] = ch;
        return false;
    }
    public static List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length;
        int COLS = board[0].length;
        Set<String> set = new HashSet<>();
        for(int r = 0; r < ROWS ; r++){
            for(int c = 0; c < COLS; c++){
                for(String word:words){
                    if (!set.contains(word)){
                        if ( exists( board, r, c, word, "")){
                            set.add(word);
                        }
                    }
                }
            }
        }
        for(int r = 0; r < ROWS ; r++){
            for(int c = 0; c < COLS; c++){
                System.out.print(board[c][r]);
            }
            System.out.println();
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

        char[][] arr = new char[][]{{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String [] words = new String[]{"oath","pea","eat","rain"};
        System.out.println(findWords( arr, words));
    }
}
