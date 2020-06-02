package c17;

import java.util.*;

public class q14 {
    public static String parse(String src, List<String> dict){
      Collections.sort(dict, new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
              return o2.length()-o1.length();
          }
      });
      src = src.toUpperCase();
      for(String item:dict){
          src = src.replace(item.toUpperCase(), " " + item.toLowerCase() + " ");
      }
      return src;
    }
    public static void main(String[] args) {
        List<String> dict = Arrays.asList( "looked","just","like","her", "brother");
        System.out.println(parse("jesslookedjustliketimherbrother", dict));
    }
}
