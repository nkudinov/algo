package lc.june2020;

import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q13 {

    static  public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ret = new ArrayList<>();
        if (nums.length == 1){
            ret.add(nums[0]);
        }
        for(int i = 0; i < nums.length;i++){
            if (nums[i] ==1 ){
                continue;
            }
            int a = nums[i];
            List<Integer> tmp =new ArrayList<>();
            tmp.add(a);
             for(int j = i+1; j < nums.length;j++ ) {
                if (i == j){
                    continue;
                }
                int b = nums[j];
                if (a%b ==0 || b%a==0){
                    tmp.add(b);
                }
            }
             if (tmp.size() > ret.size()){
                 ret = tmp;
             }
        }
        if (nums.length > 0 && nums[0] == 1){
            if (!ret.contains(1)){
                ret.add(1);
            }
        }
       // Collections.sort(ret);
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,6,24};
        //System.out.println(Arrays.toString(arr));
        System.out.println(largestDivisibleSubset(arr));
    }

}
