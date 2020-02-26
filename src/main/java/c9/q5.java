package c9;

import java.util.HashSet;
import java.util.Set;

public class q5 {
    static public String insert(String str, int index,Character c) {
       String l = str.substring(0,index);
       String r = str.substring(index);
       return  l + c + r;
    }
    static public Set<String> permutations(String str){
        Set<String>  ret = new HashSet<>();
        for(int i = 0 ; i < str.length(); i++) {
           Character ch = str.charAt(i);
           Set<String>  tmp = new HashSet<>();
           if (ret.size() == 0){
               tmp.add(ch+"");
           } else {
               for (String word : ret) {
                   tmp.add(ch + word);
                   for (int j = 1; j < word.length(); j++) {
                       tmp.add(insert(word, j, ch));
                   }
                   tmp.add(word + ch);
               }
           }
           ret = tmp;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(permutations("12345"));
    }
}
