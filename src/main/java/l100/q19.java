package l100;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.List;

public class q19 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0){
            return ans;
        }
        for(int i = 0; i < numRows; i++){
            ans.add(new ArrayList<>());
            for(int j = 0; j <= i; j ++ ){
                if ( i == 0 && j == 0){
                    ans.get(i).add(1);
                } else {
                    int v1 = j-1>=0?ans.get(i-1).get(j-1):0;
                    int v2 = j<i?ans.get(i-1).get(j):0;
                    ans.get(i).add(v1 + v2);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        for(List<Integer> lst:generate(4)){
            System.out.println(lst);
        }
    }
}
