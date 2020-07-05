package lc.July2020;

public class d5 {
    static public int hammingDistance(int x, int y) {
        int tmp = x^y;
        int ret = 0;
        System.out.println(Integer.toBinaryString(tmp));
        while(tmp > 0){
            ret += tmp&1;
            tmp =  tmp>>1;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
}

