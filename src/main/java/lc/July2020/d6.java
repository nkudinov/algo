package lc.July2020;

import java.util.Arrays;

public class d6 {
    static public int[] plusOne(int[] digits) {
      int carry = 0;
      int[] ret = Arrays.copyOf(digits, digits.length);
      int i = digits.length-1;
      do {
          if (i == digits.length-1){
              ret[i] = (digits[i]+1+carry)%10;
              carry = (digits[i]+1+carry)/10;
          } else if ( i == -1 ){
            int[] tmp = new int[ret.length+1];
            for(int j = digits.length-1;j>=0;j--){
                tmp[j+1] = ret[j];
            }
            tmp[0] = carry;
            carry = 0;
            ret = tmp;
          } else {
              ret[i] = (digits[i]+carry)%10;
              carry = (digits[i]+carry)/10;
          }
          i--;
      } while(carry > 0);

      return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

}
