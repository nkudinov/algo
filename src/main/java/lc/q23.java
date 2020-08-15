package lc;

public class q23 {
    public static void test(int N){
        for(int i = 0; i <= (1 << N)-1; i++){
            System.out.println(Integer.toBinaryString(i));

        }
    }
    public static void main(String[] args) {
        test(3);
    }
}
