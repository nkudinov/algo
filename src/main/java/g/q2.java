package g;

import java.util.ArrayList;
import java.util.List;

public class q2 {
    static  public String licenseKeyFormatting(String S, int K) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = S.length()-1; i >=0; i--){
            char ch = S.charAt(i);
            if (ch!='-') {
                if (cnt % K == 0 && cnt != 0) {
                    sb.append('-');
                }
                cnt++;
                sb.append(ch);
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w",4));
        System.out.println(licenseKeyFormatting("2-5g-3-J",2));
    }
}
