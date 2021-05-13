package ss;

public class q7 {
   static void print(int[][] matrix){
       int N = matrix.length;
       for(int i = 0 ; i < N; i++){
           for(int j = 0; j < N; j++){
               System.out.print(matrix[i][j]+" ");
           }
           System.out.println();
       }
   }
   static void swap(int[][] matrix, int i, int j){
       int tmp = matrix[i][j];
       matrix[i][j] = matrix[j][i];
       matrix[j][i] = tmp;
   }
   static void transpose(int[][] matrix){
        int N = matrix.length;
        for(int i = 0 ; i < N; i++){
            for(int j = i+1; j < N; j++){
                swap(matrix, i, j);
            }
            System.out.println();
        }
    }
    static void reverse(int[] arr){
       int l = 0;
       int r = arr.length-1;
       while( l < r){
           int tmp = arr[l];
           arr[l] = arr[r];
           arr[r] = tmp;
           l++;
           r--;
       }
    }
    static void reverse(int[][] matrix){
       int N = matrix.length;
       for(int i =0; i < N; i++){
          reverse(matrix[i]);
       }
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{new int[]{1,1,1}
                                , new int[]{2,2,2}
                                , new int[]{3,3,3}};
        transpose(arr);
        print(arr);
        System.out.println("---");
        reverse(arr);
        print(arr);
    }
}
