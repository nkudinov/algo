package c1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class q1 {

    public static boolean isAllUnique1(String str){
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

    public static boolean isAllUnique2(String str){
       char [] arr = str.toCharArray();
       Arrays.sort(arr);
       for(int i=0; i < arr.length - 1;i++){
           if (arr[i] == arr[i+1]){
               return false;
           }
       }
       return true;
    }

    public static boolean isAllUnique3(String str){
        for(int i = 0; i < str.length();i++){
            for(int j = i + 1; j<str.length();j++){
                if (str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAllUnique4(String str){

        if ( str.length() == 256){
            return false;
        } else {
           boolean [] arr = new boolean[256];
           for(int i = 0; i < str.length(); i++){
               int index = str.charAt(i);
               if (arr[index]){
                   return false;
               } else {
                   arr[index] = true;
               }
           }
        }
        return true;
    }

    public static boolean isAllUnique5(String str){
        int checker = 0 ;
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i) -'a';
         if ((checker & (1 << val)) > 0){
             return false;
         }
         checker = checker | (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println( isAllUnique5("abc"));
        //System.out.println(3 << 1);
    }
}
