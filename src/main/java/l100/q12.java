package l100;

import java.util.ArrayList;
import java.util.List;

public class q12 {
    public static boolean isSeq(int i){
        int prev = i % 10;
        i = i/10;
        while( i > 0 ){
            if ( (i%10 + 1) != prev){
                return false;
            }
            prev = i%10;
            i = i/10;
        }
        return true;
    }
    public static List<Integer> sequentialDigits0(int low, int high) {
        List<Integer> asn = new ArrayList<>();
        for(int i = low ; i <= high; i++){
            if (isSeq(i)){
                asn.add(i);
            }
        }
        return asn;
    }
    public static List<Integer> sequentialDigits1(int low, int high) {
        String str = "123456789";
        int len = String.valueOf(low).length();
        List<Integer> ans = new ArrayList<>();
        while(true){
           for(int i = 0; i < str.length() - len; i++){
               int curr = Integer.parseInt(str.substring(i, i +len));
               if (curr > high){
                   return ans;
               }
               ans.add(curr);
           }
           len++;
        }

    }

    public static void main(String[] args) {


        for(Integer x:sequentialDigits1(100,999)){
            System.out.println(x);
        }
    }
}
