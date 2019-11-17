package c3;

import java.util.Deque;
import java.util.LinkedList;

public class q6 {

     public static <A extends Comparable<A>> Deque<A> sort(Deque<A> stack){
         Deque<A> retVal = new LinkedList<>();
         while(!stack.isEmpty()){
            A value = stack.pop();
            while(!retVal.isEmpty() && retVal.peek().compareTo( value) > 0 ){
                stack.push(retVal.pop());
            }
            retVal.push(value);
         }
         return retVal;
     }

    public static void main(String[] args) {
        Deque<Integer> s = new LinkedList<>();
        s.push(1);
        s.push(0);
        s.push(2);
        System.out.println(sort(s).toString());
    }

}
