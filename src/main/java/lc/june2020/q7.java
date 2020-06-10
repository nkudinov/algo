package lc.june2020;

import java.util.*;

public class q7 {

    public static int helper(int amount, int[] coins, int acc, int max){
        if (acc == amount){
            return 1;
        }
        int ret = 0;
        for (int i = max; i < coins.length; i++) {
             if (acc + coins[i] <= amount) {
                 ret += helper( amount, coins, acc + coins[i], i);
             }
        }
        return ret;
    }
    public static int change(int amount, int[] coins) {
        int arr[] = new int[amount+1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for(int coin : coins){
            for(int i = coin; i <= amount; i++)
                arr[i] += arr[i-coin];
        }
        return arr[amount];
    }

    public static void main(String[] args) {
      int[] coins  = new int[] {1, 2, 5};

      int n =  change(5, coins);
      //35502874
      System.out.println(n);
    }
}
