package f;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q76 {
    private static void helper(int index, String num, long previousOperand, long currentOperand, long value, long target, Set<String> acc, String curr){
        if ( index == num.length()){
            if ( value == target && currentOperand == 0){
                if (Character.isDigit(curr.charAt(0)))
                    acc.add(curr);
                else
                    acc.add(curr.substring(1));
            }
            return;
        }
        char ch = num.charAt(index);
        currentOperand = currentOperand*10+(ch-'0');
        if (currentOperand > 0 ){
            helper(index+1, num, previousOperand, currentOperand, value, target, acc, curr);
        }
        helper(index+1, num, currentOperand,0, value + currentOperand, target, acc, curr+'+'+currentOperand);
        if ( curr.length() >0 ){
            helper(index+1, num, -currentOperand,0, value - currentOperand, target, acc, curr+'-'+currentOperand);
            //1+2*2
            helper(index+1, num, currentOperand * previousOperand,0, value - previousOperand + (currentOperand * previousOperand), target, acc, curr+'*'+currentOperand);
        }
    }
    public static List<String> addOperators(String num, int target) {

        if ( num == null || num.length() == 0){
            return new ArrayList<>();
        }
        Set<String> ret = new HashSet<>();
        helper(0, num, 0,0, 0, target, ret,"");
        return new ArrayList<>(ret);
    }
    public static void main(String[] args) {
     List<String> ret = addOperators("123456789",100);
     for(String s:ret){
         System.out.println(s);
     }
    }
}
