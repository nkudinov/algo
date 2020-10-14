package lc;

public class q25 {
    public static String getShortURL(int n){
        String dict = "0123456789abcd";
        StringBuilder sb = new StringBuilder();
        int base = dict.length();
        while(n > 0){
            sb.append(dict.charAt( n % base));
            n = n/base;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(getShortURL(1));

    }
}
