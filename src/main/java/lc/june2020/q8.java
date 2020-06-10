package lc.june2020;

public class q8 {
    static public boolean isPowerOfTwo(int n) {
       return ((n & n - 1) == 0 );
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(6));
    }
}
