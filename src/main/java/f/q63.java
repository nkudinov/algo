package f;

public class q63 {
    public static int divide(int dividend, int divisor) {
        int sign = 0;
        if (divisor < 0){
            sign++;
            divisor = -divisor;
        }
        if(dividend < 0){
            sign++;
            dividend = -dividend;

        }
        int ret = 0;
        while (dividend-divisor>=0){
            ret++;
            dividend -= divisor;
        }
        if ( sign == 1){
            return -ret;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,
                -1));
    }

}
