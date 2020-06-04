package c18;

import java.util.Random;

public class q1 {
    public static int getBit(int i, int x){
        return 1 & ( i>>x);
    }
    public static int add(int a, int b){
        int ret   = a;
        int carry = 0;
        for(int i=0; i< 31; i++){
            if ((getBit(i, ret) & carry) == 1){
                ret = ret^( carry<<i);
                carry = 1;
            }

           int bBit = getBit(i, b);
           if ((getBit(i, ret) & getBit(i, b)) == 1){
                carry = 1;
           } else {
                carry = 0;
           }
           ret = ret^( getBit( i, b)<<i);
           System.out.println("i =" + i +" bBit="+ bBit+" " +Integer.toBinaryString(ret)+" " + carry);
        }
        return ret;
    }
    public static void main(String[] args) {
//        Random rand = new Random();
//        for(int i=0;i < 100;i++){
//            System.out.println(i);
//            int a = rand.nextInt(100);
//            int b = rand.nextInt(100);
//            if ( a+b != add(a,b)){
//                throw new RuntimeException("can not add "+ a +" and " + b);
//            }
//        }
        // ‭00101000‬
        //‭ 10001000‬
        //-----------
        //     0000
        // ‭10000000‬
        System.out.println(add(40,88));
    }
}
