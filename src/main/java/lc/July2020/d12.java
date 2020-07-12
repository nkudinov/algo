package lc.July2020;

public class d12 {
    // you need treat n as an unsigned value
    static public int reverseBits(int n) {
        int ret = 0;
        for(int i = 0; i <= 31; i++){
           int bit = (n >> i) & 1;
           ret = (bit << (31 - i)) | ret;
        }
       return ret;
    }

    public static void main(String[] args) {
        Integer x = Integer.valueOf("00000010100101000001111010011100",2);
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
        Integer y = reverseBits(x);
        System.out.println(y);
        System.out.println(Integer.toBinaryString(y));
    }
}
