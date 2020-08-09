package permutation;

import java.util.ArrayList;
import java.util.List;

public class s4 {

    static String swap(String str, int i, int j){
        char[] arr = str.toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return new String(arr);
    }

    static void perm(String s, int n, List<String> acc){
         if (n == 1){
             acc.add(s);
         }
         for(int i = 0; i < n;i++){
             String str = swap(s, i,n-1);
             perm( str,n-1, acc);
         }
    }

    public static void main(String[] args) {
        List<String> ret = new ArrayList<>();
        perm("12345",5, ret);
        int i =1;
        for(String s:ret){
            System.out.println((i++)+" "+ s);
        }
    }
}
