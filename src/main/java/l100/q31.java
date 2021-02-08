package l100;

public class q31 {
    public  static  int primePalindrome(int N) {
        if ( 8 <= N && N <= 11){
            return 11;
        }
        int max = 10000;
        boolean[] nums = new boolean[max];
        for(int i = 1; i < max; i++ ){
           for( int j = 0; j  < 10; j++){
               int x = Integer.parseInt(""+i+""+j+""+reverse(i));
               if (isPrime(x)){
                   System.out.println(x);
               }
           }
        }
        return 1;
    }
    private static boolean isPrime(int x){
        for(int i = 2; i < x; i++){
            if ( x % i == 0){
                return false;
            }
        }
        return true;
    }
    private static  int reverse(int x){
        int ans =0;
        while(x >0 ){
            ans = ans*10+x%10;
            x = x/10;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(primePalindrome(100));
    }
}
