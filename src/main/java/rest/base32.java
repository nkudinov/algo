package rest;

public class base32 {
   public static String encode32(int num){
       String code = "0123456789abcdefghijklmnopqrstuvwxyz";
       StringBuilder sb = new StringBuilder();
       while (num != 0 ) {
           sb.append(code.charAt(num%code.length()));
           num = num/code.length();
       }
       return sb.toString();
   }
   public static int decode32(String text){
       String code = "0123456789abcdefghijklmnopqrstuvwxyz";
       int num = 0;
       int j = text.length();
       for(int i = 0; i < j; i++){
           num += code.indexOf(text.charAt(0))*Math.pow(code.length(), i);
           text = text.substring(1);
       }
       return num;
   }
   public static void main(String[] args) {
       System.out.println(encode32(111222333));
       System.out.println(decode32("9pv7u1"));
   }
}
