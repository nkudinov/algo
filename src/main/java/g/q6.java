package g;

import scala.Array;
import scala.Int;

import java.util.*;

public class q6 {

    static public int count( int[] arr, int from, int to, int num){
       int ret = 0;
       for(int i = from; i <= to ;i++){
          if (arr[i] < num){
              ret++;
          }
       }
       return ret;
    }
    static public List<Integer> countSmaller(int[] nums) {
       TreeSet<Integer> tset = new TreeSet<>();
       Integer[] ret = new Integer[nums.length];
       for(int i = nums.length-1; i >= 0; i--){
           ret[i] = count( nums, i ,nums.length - 1, nums[i]);
       }
       return Arrays.asList( ret);
    }
    public static void main(String[] args) {
        System.out.println(countSmaller(new int[] {66,65,36,100,41}));
    }
}
