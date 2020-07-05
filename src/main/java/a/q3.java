package a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q3 {
    static private String insert(char ch, String str, int i){
        if (i == 0){
            return ch+str;
        } else if (i == str.length()){
            return str+ch;
        }
        return str.substring(0,i)+ch+str.substring(i);

    }
    static private Set<String> helper(String str, Set<String> acc){
        if (str == null || str.length() ==0 ){
            return acc;
        }
        char ch = str.charAt(0);
        String xs = str.substring(1);
        Set<String> newAcc = new HashSet<>();
        for(String lst:acc){
           for(int i = 0; i <= lst.length();i++){
               newAcc.add(insert(ch,lst,i));
           }
        }
        return helper(xs, newAcc);
    }/*
    abc
    a
    */
    static public Set<String> permutate(String str){
       Set<String> lst = new HashSet<>();
       lst.add(str.charAt(0)+"");

       return helper(str.substring(1), lst);
    }

    public static void main(String[] args) {
        for(String s:permutate("abcd")){
            System.out.println(s);
        }
//        System.out.println(insert('a',"bc",0));
//        System.out.println(insert('a',"bc",1));
//        System.out.println(insert('a',"bc",2));
    }
}
