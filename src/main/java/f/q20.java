package f;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class q20 {

    static int minOverallAwkwardness(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = len-1; i >= 0; i--){
            if (i % 2 == 0) {
                list.addLast(nums[i]);
            }else{
                list.addFirst(nums[i]);
            } //5, 6, 8, 10,
        }
        System.out.println(list);
        int max = 0;
        int prev = list.get(len-1);
        for (int i=0; i < len; i++){
            max = Math.max(Math.abs(list.get(i)-prev), max);
            prev = list.get(i);
        }

        return max;

    }

    public static void main(String[] args) {
         System.out.println(minOverallAwkwardness(new int[]{5, 10, 6, 8}));
    }
}
