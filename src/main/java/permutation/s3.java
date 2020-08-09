package permutation;

import java.util.ArrayList;
import java.util.List;

public class s3 {
    static void perm(String s, List<String> acc, String buf){
        if (s == null || s.length() == 0){
            acc.add(buf);
        }
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            String ros = s.substring(0,i) + s.substring(i+1);
            perm(ros, acc, buf + ch);
        }
    }
    public static void main(String[] args) {
        List<String> ret = new ArrayList<>();
        perm("12345",ret,"");
        int i =1;
        for(String s:ret){
            System.out.println((i++)+" "+ s);
        }
    }
}
