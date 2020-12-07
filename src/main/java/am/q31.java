package am;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class q31 {
    static Map<Integer,String> r = new HashMap<>();
    static {
        r.put(1,"I");
        r.put(4,"IV");
        r.put(5,"V");
        r.put(9,"IX");
        r.put(10,"X");
        r.put(40,"XL");
        r.put(50,"L");
        r.put(90,"XC");
        r.put(100,"C");
        r.put(400,"CD");
        r.put(500,"D");
        r.put(900,"CM");
        r.put(1000,"M");
    }
    public static String intToRoman2(int num) {
        if (num == 4 ){
            return "IV";
        } else if (num == 9 ){
            return "IX";
        }
        StringBuilder sb = new StringBuilder();
        for( Integer k: new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1}){
            int a = num/k;
            if (a != 0){
                for (int i = 0; i < a; i++)
                    sb.append(r.get(k));
            }
            num = num %k;
        }
        return sb.toString();
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for( Integer k: new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1}){
            int a = num/k;
            if (a != 0){
                for (int i = 0; i < a; i++)
                    sb.append(r.get(k));
            }
            num = num %k;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(4));
        System.out.println(intToRoman2(4));
    }
}
