package am;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q29 {
    public static void helper(int[] jobDifficulty, int i, int d, int curr, List<Integer> acc){
        if ( i == jobDifficulty.length && d == 0){
            acc.add(curr);
        } else if  ( d < 0) {
            return;
        } else {
            int difficulty = 0;
            for(int j = i; j< jobDifficulty.length; j++){
                difficulty = Math.max(difficulty, jobDifficulty[j]);
                helper(jobDifficulty, j+1, d-1, curr + difficulty, acc);
            }

        }
    }
    public static int minDifficulty(int[] jobDifficulty, int d) {
        List<Integer> acc = new ArrayList<>();
        helper(jobDifficulty, 0, d, 0, acc);
        return acc.size()==0?-1:Collections.min(acc);
    }

    public static void main(String[] args) {
        //[9,9,9]
        //[6,5,4,3,2,1]
        int[] arr = new int[]{6,5,4,3,2,1};
        System.out.println(minDifficulty(arr, 2));

    }
}
