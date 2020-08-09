package lc;

public class q20 {
    public static int reverse(int x) {

        int sign = (int)Math.signum(x);
        x = Math.abs(x);
        if ( x>= 1534236469 ){
            return 0;
        }
        long ret = 0;
        while(x > 0){
            if (ret > Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE / 10 && x%10 > 7)) return 0;
            ret *= 10;
            ret += x%10;
            x /= 10;

        }
        System.out.println(sign);
        if ( (sign == 1 && ret > Integer.MAX_VALUE) || (sign == -1 && ret > ((long)Integer.MAX_VALUE) +1)){
            return 0;
        }
        return sign*((int) ret);
    }
    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }

}
