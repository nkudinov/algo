package l100;

import java.util.ArrayList;
import java.util.List;

public class q14 {
    private static void helper(String s, int curr, String ip,  List<String> acc){
       if ( s == null || s.length() == 0 ){
           acc.add(ip);
       } else {
         int ch  = s.charAt(0) - '0';
//         if (){
//
//         }
       }
    }
    public static List<String> restoreIpAddresses(String s) {
       List<String> ans = new ArrayList<>();
       //helper(s, ans);
       return ans;
    }

    public static void main(String[] args) {
      String s = "0000";
      for(String str:restoreIpAddresses(s)){
          System.out.println(str);
      }
    }

}
