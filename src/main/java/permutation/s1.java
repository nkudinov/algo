package permutation;

import java.util.*;

public class s1 {
    static String insert(String str, int i,char ch){
       if (i == 0){
          return ch+str;
       } else if (i == str.length()){
          return str+ch;
       } else {
           return str.substring(0,i)+ch+str.substring(i);
       }
    }
    static List<String> perm(String s){
      Queue<String> q = new LinkedList<>();
      q.add(s.substring(0,1));
      for(char ch:s.substring(1).toCharArray()){
          int n = q.size();
          for(int i = 1; i <= n;i++){
              String str = q.poll();
              for(int j = 0; j <= str.length();j++){
                  q.add(insert(str,j, ch));
              }
          }
      }
      List<String> ret = new LinkedList<>();
      while (!q.isEmpty()){
          String str = q.poll();
          if (str.length() == s.length()){
              ret.add(str);
          }
      }
      return ret;
    }
    public static void main(String[] args) {
        for(String s:perm("123")){
            System.out.println(s);
        }
//        System.out.println(insert("12",0,'3'));
//        System.out.println(insert("12",1,'3'));
//        System.out.println(insert("12",2,'3'));
    }
}
