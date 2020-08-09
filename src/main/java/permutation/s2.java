package permutation;

import java.util.ArrayList;
import java.util.List;

public class s2 {
    static String insert(String str, int i,char ch){
        if (i == 0){
            return ch+str;
        } else if (i == str.length()){
            return str+ch;
        } else {
            return str.substring(0,i)+ch+str.substring(i);
        }
    }
    static List<String> perm( String s, List<String> acc){
        if (s == null || s.length() == 0){
            return acc;
        }
        char ch = s.charAt(0);
        List<String> tmp = new ArrayList<>();
        for(int j = 0; j < acc.size();j++){
            String elem = acc.get(j);
            for(int i = 0; i <= elem.length();i++){
                tmp.add(insert(elem,i,ch));
            }
        }
        return perm(s.substring(1), tmp);
    }
    public static void main(String[] args) {
        List<String> acc = new ArrayList<>();
        acc.add("1");
        int i = 1;
        for(String s:perm("2345", acc)){
            System.out.println(i +" " +s);
            i++;
        }
    }

}
