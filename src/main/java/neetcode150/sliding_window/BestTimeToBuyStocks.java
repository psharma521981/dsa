package src.neetcode150.sliding_window;

public class BestTimeToBuyStocks {
    public int maxProfit(int[] prices) {
       //Validate the input

       if(prices==null || prices.length < 2)
           return 0;

       //Initialize minimum profit and Max price
       int price = Integer.MAX_VALUE;
       int maxProfit = 0;

       //Check for every price that price is comparatively low and calculate max profit for that price
       for(int i=0; i < prices.length;i++) {

           if(prices[i] < price) {
               price = Math.min(prices[i],price);
           }
           maxProfit = Math.max(maxProfit,prices[i]-price);

       }

        return maxProfit;
    }
    public static void main(String[] args) {
        BestTimeToBuyStocks solution = new BestTimeToBuyStocks();
        int[] example1 = {3, 2, 6, 5, 0, 3};
        int[] example2 = {8, 6, 5, 2, 1};
        int[] example3 = {1, 2};
        System.out.println(solution.maxProfit(example1)); // Output: 4
        System.out.println(solution.maxProfit(example2)); // Output: 0
        System.out.println(solution.maxProfit(example3)); // Output: 1
    }
}
