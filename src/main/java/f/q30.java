package f;

public class q30 {
    public static String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while( i >= 0 || j >= 0) {

            char ch1;
            char ch2;

            if ( i < 0){
                ch1 = '0';
            } else {
                ch1 = a.charAt(i);
            }

            if (j < 0 ){
                ch2 ='0';
            } else {
                ch2 = b.charAt(j);
            }

            int v1 = ch1 - '0';
            int v2 = ch2 - '0';

            int vl = ( carry + v1 + v2)%2;
            carry  = ( carry + v1 + v2)/2;
            sb.append( vl == 0 ?'0':'1');
            i--;
            j--;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(addBinary("1","1"));
    }
}
