package lc;

public class d19 {
    static public int maxProfit1(int[] prices) {
         int ret  = 0;
         for(int i = 1; i < prices.length;i++){
             if (prices[i] > prices[i-1]){
                ret += prices[i] - prices[i-1];
             }
         }
         return ret;
    }
    static public int helper(int[] prices,   String transactions, int count){
        if ( transactions.length() == prices.length){
            int ret  =0;
            int cnt = 0;
            for(int j = 0; j < prices.length; j++){
                char tr = transactions.charAt(j);
                if (tr == 'b' && cnt==0){
                    ret -= prices[j];
                    cnt +=1;
                } else if ( tr =='s'){
                    if (cnt > 0) {
                        ret += prices[j];
                        cnt--;
                    }
                }
            }
            //System.out.println(transactions+"="+ret);
            return ret;
        }
        int buy =0 ;
        int sell = 0;
        if (count == 0) {
            buy = helper(prices, transactions + "b", 1);
        }
        if( count == 1) {
            sell = helper(prices, transactions + "s", 0);
        }
        int pass = helper(prices,transactions + "p", count);
        return Math.max( Math.max(buy,sell),pass);
    }
    static public int maxProfit2(int[] prices) {
       return helper(prices,  "", 0);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,7,5,6,2,5,1,9,7,9,7,0,6,8};
        //
       // System.out.println(maxProfit1( arr));
        System.out.println(maxProfit2( arr));
    }

}
