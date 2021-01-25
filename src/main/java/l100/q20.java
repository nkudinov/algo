package l100;

public class q20 {
    static public int maxProfit(int[] prices) {
        int bestPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if (prices[i] < bestPrice){
                bestPrice = prices[i];
            } else {
                maxProfit += prices[i] - bestPrice;
                bestPrice = Integer.MAX_VALUE;
            }

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
