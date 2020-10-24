package f;

public class q73 {
    static public String one(int num){
        switch (num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
         }
        return "";
    }
    static public String  twoLessThan20(int num){
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }
    static public String two(int num){
       if ( num == 0 ){
           return "";
       } else if ( num < 10){
           return one(num);
       } else if (num < 20){
           return twoLessThan20(num);
       }
       return "x";
    }
    public static String three(int num){
        int hundred = num/100;
        int rest = num - hundred*100;
        String ret = "";
        if ( hundred != 0){
            ret += one(hundred) +" Hundred ";
        }
        if ( rest != 0){
            ret += two(rest);
        }
        return ret;
    }
    public static String numberToWords(int num) {

      int billion  = num / 1_000_000_000;
      int million  = (num - billion*1_000_000_000)/1_000_000;
      int thousand = (num - billion*1_000_000_000 - million*1_000_000)/1000;
      int rest = (num - billion*1_000_000_000 - million*1_000_000- thousand*1000);

      String result = "";
      if (billion!=0){
          result += three(billion) + " Billion";
      }
     if (million!=0){
          if (! result.isEmpty())
                result += " ";
           result += three(million) + " Million";
     }
     if (thousand!=0){
          if (! result.isEmpty())
                result += " ";
          result += three(thousand) + " Thousand";
     }
     if (rest!=0){
            if (! result.isEmpty())
                result += " ";
            result += three(rest);
     }
     return result;
    }

    public static void main(String[] args) {
        int x = 2_100_800_901;
        System.out.println(numberToWords(x));
    }

}
