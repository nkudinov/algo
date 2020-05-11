package c17;

public class q3 {

    static public int getTrailingZerosOfFactorial(int n){
        // 100!= 2*3...25...100
        int d = 1;
        int c = 0;
        while( n/d >0 ){
           d = d*5;
           c += n/d;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(getTrailingZerosOfFactorial(100));
        System.out.println(getTrailingZerosOfFactorial(5));
        System.out.println(getTrailingZerosOfFactorial(10));
    }
}
