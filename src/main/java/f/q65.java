package f;

public class q65 {
    private static int HALF_INT_MIN = -1073741824;
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = 0;
        if (divisor > 0){
            sign++;
            divisor = - divisor;
        }
        if(dividend > 0){
            sign++;
            dividend = - dividend;
        }
        int count = 0;
        while ( divisor >= dividend  ){
            int power = 1;
            int value = divisor;
            while( value >= HALF_INT_MIN && value + value >= dividend){
                value = value + value;
                power = power + power;
            }
            dividend -= value;
            count += power;
        }
        if (sign == 1){
            return -count;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println( divide(33,3));
    }
}
