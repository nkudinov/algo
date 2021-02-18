package l100;

public class q37 {
    public static int helper(int m, int n, int N, int i, int j){
        if ( i < 0 || i == m || j < 0 || j == n ){
           return 1;
        }
        if ( N == 0){
            return 0;
        }
        int ans = 0;
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] dir:directions){
            int newI = i + dir[0];
            int newJ = j + dir[1];
            ans += helper(m, n, N -1, newI, newJ);
        }
        return ans;
    }
    public  static int findPaths(int m, int n, int N, int i, int j) {
        return helper(m, n, N, i, j);
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        int N = 2;
        int i = 0;
        int j = 0;
        System.out.println(findPaths(m,n,N,i,j));
    }
}
