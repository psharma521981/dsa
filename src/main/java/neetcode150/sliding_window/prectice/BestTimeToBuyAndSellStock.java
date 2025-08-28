package neetcode150.sliding_window.prectice;
//prices=[7,1,5,3,6,4]
public class BestTimeToBuyAndSellStock {
    //Two pointers
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length < 2)
            return 0;

       int left = 0;
       int right = left + 1;
       int maxProfite = 0;

       while (right < prices.length) {

            if(prices[left] < prices[right]) {
                maxProfite = Math.max(maxProfite,prices[right] - prices[left]);
            } else {
                left =right;
            }
           right++;
       }
        return maxProfite;
    }
}
