package c5;

public class q2 {
    public static String toBinaryString1(double d){
       StringBuilder sb = new StringBuilder(".");
       while( d > 0){
           d = d*2;
           if (d>=1){
              sb.append("1");
              d = d -1;
           } else {
              sb.append("0");
           }
       }
       return sb.toString();
    }
    public static String toBinaryString2(double d){
        StringBuilder sb = new StringBuilder(".");
        double frac = 0.5;
        while( d > 0){
            if (d >= frac){
                sb.append("1");
                d = d - frac;
            } else {
                sb.append("0");
            }
            frac = frac/2;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(toBinaryString1(0.72));
        System.out.println(toBinaryString2(0.72));
    }
}
