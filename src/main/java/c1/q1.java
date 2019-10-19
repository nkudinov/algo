package c1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class q1 {

    public static boolean isAllUnique(String str){
        Set<Character> hs = new HashSet<>();
        for( Character e: str.toCharArray()){
            if (hs.contains(e)){
                return false;
            } else {
                hs.add(e);
            }
        }
        return true;
    }

    public static boolean isAllUnique1(String str){
       char [] arr = str.toCharArray();
       Arrays.sort(arr);
       for(int i=0; i < arr.length - 1;i++){
           if (arr[i] == arr[i+1]){
               return false;
           }
       }
       return true;
    }

    public static void main(String[] args) {
        System.out.println( isAllUnique1("pp"));
    }
}
