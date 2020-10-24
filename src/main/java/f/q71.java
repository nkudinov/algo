package f;

public class q71 {
    public static String addStrings(String num1, String num2) {
        int n = num1.length()-1;
        int m = num2.length()-1;
        int i = n;
        int j = m;
        int carry = 0;
        StringBuilder  sb = new StringBuilder();
        while( i >= 0 || j >=0 ){
            char ch1 = (i>=0)?num1.charAt(i):'0';
            char ch2 = (j>=0)?num1.charAt(j):'0';
            int d1 = ch1 -'0';
            int d2 = ch2 -'0';

            int value = d1+d2+carry;
            carry = value/10;
            value = value%10;
            sb.append(value);
            i--;
            j--;
        }
        if (carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("0","9"));
    }
}
