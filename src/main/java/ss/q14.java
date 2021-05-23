package ss;

import java.util.Arrays;

public class q14 {
    static int[] spiralCopy(int[][] m) {
        // your code goes here
        int lCol = 0;
        int rCol = m[0].length-1;

        int tRow = 0;
        int bRow = m.length-1;

        int k = 0;
        int N = m.length*m[0].length;
        int[] ans = new int[N];
        while( k < ans.length){
            for(int c = lCol ; c <= rCol && k < N ;c++){
                ans[k++] = m[tRow][c];
            }
            tRow++;
            for(int r = tRow; r <= bRow && k < N ; r++){
                ans[k++] =  m[r][rCol];
            }
            rCol--;
            for(int c = rCol ; c >= lCol && k < N  ;c--){
                ans[k++] = m[bRow][c];
            }
            bRow--;
            for(int r = bRow ; r >= tRow && k < N ;r--){
                ans[k++] = m[r][lCol];
            }
            lCol++;

        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiralCopy(new int[][]{{1,2}})));
    }


}
