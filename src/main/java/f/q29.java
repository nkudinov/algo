package f;

import scala.Array;
import scala.Int;

import java.util.*;

public class q29 {
    public static int[] insert(int[] arr, int index, int value) {
        int[] ret = new int[arr.length+1];
        int i = 0;
        int j = 0;
        while( i!= index){
            ret[i] = arr[j];
            i++;
            j++;
        }
        ret[i] = value;
        i++;
        while( i < ret.length){
            ret[i] = arr[j];
            i++;
            j++;
        }
        return ret;
    }
    public static void nextPermutation(int[] nums) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            if (i == 0){
                int[] arr = new int[]{nums[i]};
                q.add(arr);
            } else {
              int n = q.size();
              for(int j = 1 ; j <=n ;j++){
                  int[] tmp  = q.poll();
                  for(int k = 0; k <= tmp.length; k++){
                      q.add( insert(tmp, k, nums[i]));
                  }
              }
            }
        }
        int n = q.size();
        int[][] tmp = new int[n][];
        String[] permutations = new String[n];
        for(int i = 0; i <n ; i++){
            int[] arr = q.poll();
            permutations[i] = Arrays.toString(arr);
            tmp[i] = arr;
        }

        Arrays.sort( permutations);
        System.out.println(Arrays.toString(permutations));
        int index = Arrays.binarySearch(permutations, Arrays.toString(nums));
        System.out.println(index);
        String str = permutations[(index+1)%permutations.length];
        for(int i = 0; i < tmp.length; i++){
            if (Arrays.toString(tmp[i]).equals(str)){
                index = i;
            }
        }
        for(int i = 0; i < nums.length;i++){
            nums[i] = tmp[index][i];
        }

    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,5};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

}
