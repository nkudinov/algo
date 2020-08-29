package f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q41 {

    static public List<String> helper(int n){
        if ( n == 0){
            List<String> ret = new ArrayList<>();
            ret.add("");
            return ret;
        }else if( n == 1){
            List<String> ret = new ArrayList<>();
            ret.add("0");
            ret.add("1");
            ret.add("8");
            return ret;
        }
        List<String> tmp = helper(n-2);
        List<String> ret = new ArrayList<>();
        for(String s:tmp){
            ret.add("0" + s + "0");
            ret.add("1" + s + "1");
            ret.add("6" + s + "9");
            ret.add("8" + s + "8");
            ret.add("9" + s + "6");
        }
        Collections.sort(ret);
        return ret;
    }
    static public List<String> findStrobogrammatic(int n) {
          List<String> ret = helper(n);
          if (ret.size() > 1) {
              for (int i = ret.size() - 1; i >= 0; i--) {
                  String s = ret.get(i);
                  if (s.charAt(0) == '0') {
                      ret.remove(i);
                  }
              }
          }
          return ret;
    }

    public static void main(String[] args) {
        System.out.println(findStrobogrammatic(4));
    }
}
