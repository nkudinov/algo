package f;

import java.util.ArrayList;
import java.util.List;

public class q55 {

    public static void main(String[] args) {
       List<Integer> lst = new ArrayList<>();
       lst.add(0,1);
       lst.add(0,2);
       for(int x:lst){
           System.out.println(x);
       }
    }

}
