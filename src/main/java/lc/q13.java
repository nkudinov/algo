package lc;

import scala.Char;

import java.util.TreeMap;

public class q13 {
    static TreeMap<Character,Integer> r = new TreeMap<>();
    static {
        r.put('I', 1);
        r.put('V', 5);
        r.put('X', 10);
        r.put('L', 50);
        r.put('C', 100);
        r.put('D', 500);
        r.put('M', 1000);
    }
    static public int romanToInt(String s) {
      int ret =0;
      for(int i = 0; i < s.length();i++){
          Character c1 = s.charAt(i);
          if (i != (s.length() -1)){
             Character c2 = s.charAt(i+1);
             if (r.get(c1) >= r.get(c2)){
                 ret = ret + r.get(c1);
             } else {
                 ret = ret + (r.get(c2)-r.get(c1));
                 i++;
             }
          } else {
              ret = ret + r.get(c1);
          }
      }
      return ret;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
