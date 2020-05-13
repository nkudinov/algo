package c17;

public class q7 {
    static final String[] digits = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    static final String[] tens = {"Ten", "Twenty", "Thirty", "Forty","Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static final String[] teens = {"Eleven","Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen","Nineteen"};
    static final String[] bigs =  {"", "Thousand", "Million"};

    public static String num2String100(int x){
        StringBuilder sb = new StringBuilder();
        if (x > 100){
            sb.append(digits[x/100-1]);
            sb.append(" hundred");
            sb.append(" ");
        }
        x = x %100;
        if ( x > 10 && x < 20 ){
           sb.append(teens[x - 11]);
           sb.append(" ");
        } else if (x == 10 || x > 20) {
            sb.append(tens[x/10-1]);
            sb.append(" ");
        }
        x = x%10;
        if  ( x < 10){
            sb.append(digits[x-1]);
            sb.append(" ");
        }
        return sb.toString();
    }
    public static String spell(int x){
      StringBuilder sb = new StringBuilder();

      int count = 0;
      while(x !=0){
          if (x%1000 !=0 ) {
              sb.append(num2String100(x % 1000));
              sb.append(bigs[count]);
          }
          x = x/1000;
          count++;
      }
      return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(spell(2001));
    }
}
