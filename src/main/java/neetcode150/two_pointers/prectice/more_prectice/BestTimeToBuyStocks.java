package neetcode150.two_pointers.prectice.more_prectice;

public class BestTimeToBuyStocks {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1)
            return 0;

        int minPrice = prices[0];
        int maxProfit = 0;
        int index = 1;

        while(index < prices.length) {
            minPrice = Math.min(minPrice,prices[index]);
            maxProfit = Math.max(maxProfit,prices[index]-minPrice);

            index++;
        }
        return maxProfit;
    }
}
