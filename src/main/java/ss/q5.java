package ss;

import java.util.HashSet;
import java.util.Set;

public class q5 {
    static void helper(int i, String s, Set<String> acc, String path){
        if ( i == s.length() ){
            acc.add( path);
            return;
        }
        int ch = s.charAt(i);
        if (ch != '0'){
            helper( i + 1, s, acc, path +  (char)('A' + (ch -'0')-1));
        }
        if ( i + 2 <= s.length()){
            String two = s.substring(i,i+2);
            Integer val = Integer.parseInt(two);
            if ( val >= 10 && val <=26){
                //26 ->Z
                helper( i + 2, s, acc, path + (char)( 'A' + val - 1));
            }
        }
    }
    static int decodeVariations1(String s) {
        if ( s == null ||s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        Set<String> acc = new HashSet<>();
        helper(0, s, acc, "");
        return acc.size();
    }
    static int decodeVariations(String s) {
        if ( s == null ||s.length() == 0 ){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        //1262
        for(int i = 2 ; i < dp.length; i++){
            char ch = s.charAt(i-1);
             if (ch != '0'){
               dp[i] = dp[i-1];
            }
            int val = Integer.parseInt(s.substring(i-2, i));
            if (val >=10 && val <=26){
                   dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {

        //System.out.println("" +'c');
        System.out.println(decodeVariations("122231131122"));
    }


}
