package f;

public class q66 {
    static public int numDecodings(String s) {
       int[] dp = new int[s.length()+1];
       dp[0] = 1;
       dp[1] = (s.charAt(0)=='0')?0:1;

       for(int i = 2; i < dp.length; i++){
           if (s.charAt(i-1)!=0){
               dp[i] += dp[i-1];
           }
           int twoDigit = Integer.valueOf(s.substring(i-2,i));
           if (twoDigit >= 10 && twoDigit <=26){
               dp[i] += dp[i-2];
           }
       }
       return dp[dp.length-1];
    }
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }

}
