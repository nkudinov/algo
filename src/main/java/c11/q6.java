package c11;

import java.util.Arrays;

public class q6 {
    static int binarySearch(int[] a, int x, int l, int h){

        int start = l;
        int end   = h;
        int m = 0;
        while( start <= end) {
            m = (start + end)/2;
            if (a[m] == x)
                return m;
            else if ( a[m] < x) {
                start = m+1;
            }
            else {
                end = m-1;
            }

        }
        return -1;
    }
    static int[] find1(int[][] arr,int x){
      for( int i = 0; i< arr.length;i++){
         int index = binarySearch(arr[i],x,0,arr[0].length-1);
         if ( index !=-1 ){
             return new int[]{i, index};
         }
      }
        return null;
    }
    static int[] find2(int[][] arr,int x){
       int row = 0;
       int col = arr[row].length-1;
       while(row < arr.length-1 && col >= 0){
          if ( arr[row][col] == x){
              return new int[]{row,col};
          } else if ( arr[row][col] > x){
              col--;
          } else {
             row++;
          }
       }
       return null;
    }
    public static void main(String[] args) {
        int[][] arr ={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(find1(arr, 5)));
        System.out.println(Arrays.toString(find2(arr, 5)));
    }


}
