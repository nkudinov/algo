package am;

import java.util.Arrays;

public class q28 {
    public static int myAtoi(String str) {
        if ( str == null ||str.length() == 0|| str.indexOf("+-") !=-1 || str.indexOf("-+") !=-1){
            return 0;
        }
        int n = str.length();
        int i = 0;
        while(str.charAt(i) == ' ' && i < n){
            i++;
        }
        int sign = 1;
        while(str.charAt(i) == '+' && i < n){
            sign = 1;
            i++;
        }
        while(str.charAt(i) == '-' && i < n){
            sign = -1;
            i++;
        }
        int ans = 0;
        while (i < n && Character.isDigit(str.charAt(i))){
            char ch = str.charAt(i);
            int digit = ch - '0';
            digit = - digit;
            if (ans  < (Integer.MIN_VALUE - digit)/10){
                ans = Integer.MIN_VALUE;
                break;
            }
            ans = ans*10 + digit;
            i++;
        }
        if ( ans == Integer.MIN_VALUE){
            return sign == 1?Integer.MAX_VALUE:ans;
        } else {
            return sign == 1?-1*ans:ans;
        }
    }

    public static void main(String[] args) {
        //[[1,1,0],[1,1,0],[0,0,1]]

        System.out.println(myAtoi("+-42"));
    }
}
