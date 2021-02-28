package l100;

public class q48 {
    public static void main(String[] args) {
        int n = 6;
        String s1 = Integer.toBinaryString(n);
        String s2 = Integer.toBinaryString(-n);
        String s3 = Integer.toBinaryString(n&-n);
        //                             1010
        //11111111111111111111111111110110
        //2^n
        System.out.println();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

}
