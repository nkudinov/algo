package c1;

import scala.Char;

public class q5 {
    public static String compress(String str){
        StringBuilder sb = new StringBuilder();
        int count  = 1;
        Character ch = str.length() > 0 ? str.charAt(0):null;
        for(int i = 1; i < str.length();i++){
            if ( ch == str.charAt(i)){
                count +=1;
            } else {
                sb.append(ch);
                if (count > 1){
                    sb.append(count);
                }
                count = 1;
                ch = str.charAt(i);
            }
        }
        sb.append(ch);
        if (count > 1){
            sb.append(count);
        }
        return sb.toString();
    }
}
