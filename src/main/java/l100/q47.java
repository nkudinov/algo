package l100;

import java.util.*;

public class q47 {
    static boolean validate(int r, int c, List<Integer> cols, int n){

        for(int row = 0; row < n; row++) {
            if ( cols.size() > row) {
                int col = cols.get(row);
                if (col == c || row + col == r + c || row - col == r - c) {
                    return false;
                    // For all "hill" diagonals row + column = const, and for all "dale" diagonals row - column = const.
                }
            }

        }
        return true;
    }
    static List<String> makeList(List<Integer> cols, int n){
        List<String> ans = new ArrayList<>();
        for(int r = 0; r < n; r++){
            StringBuilder sb = new StringBuilder();
            for(int c = 0; c < n; c++){
                if(c == cols.get(r)){
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
    static void helper(int row, List<Integer> cols, int n, List<List<String>> acc){
        if (row == n && cols.size() == n){
            acc.add(makeList(cols,n));
        }
        for(int r = row ; r < n ; r++){
            for(int c = 0; c < n; c++){
                if(!cols.contains(c) && validate(r, c, cols, n)){
                    List<Integer> newCols= new ArrayList<>(cols);
                    newCols.add(c);
                    helper( r+1, newCols, n, acc);
                }
            }
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> acc = new ArrayList<>();
        helper(0, new ArrayList<>(), n, acc);
        return acc;
    }
    public static void main(String[] args) {
       for(List<String> lst:solveNQueens(4)){
           System.out.println(lst);
       }
    }



}
