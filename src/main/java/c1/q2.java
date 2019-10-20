package c1;

public class q2 {

     public static char [] reverse1(char[] arr) {
       int i = 0;
       int j = arr.length-1;
       while (i<j){
           char tmp = arr[i];
           arr[i] = arr[j];
           arr[j] = tmp;
           i +=1;
           j -=1;
       }
       return arr;
     }

     private static char[] helper(char[] arr,int i, char[] ret){
        if ( i > ret.length - 1){
            return ret;
        }
        ret[ret.length-i-1] = arr[i];
        return helper(arr,i+1,ret);
     }

     public static char [] reverse2(char[] arr) {
        return helper(arr,0, new char[arr.length]);
     }

    public static char [] reverse3(char[] arr) {
        char[] ret = new char[arr.length];
        for(int i = 0; i < ret.length; i++)
            ret[i] = arr[arr.length-i-1];
        return ret;
    }

}
