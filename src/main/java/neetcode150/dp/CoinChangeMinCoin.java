package src.neetcode150.dp;

//Check min number of domination needed to make the amount

public class CoinChangeMinCoin {
   public int countChange(int[] denominations, int total) {

       int[][] minCoins = new int[denominations.length][total+1];

       for(int i=0;i<denominations.length;i++) {
           for(int j=0;j<total+1;j++) {

               if(j < denominations[i] && i > 0) {
                   minCoins[i][j] = Math.min(j, minCoins[i-1][j]);
               } else if(j < denominations[i] && i == 0) {
                   minCoins[i][j] = j;
               }

               if(j >= denominations[i] && i > 0) {
                   int div = j / denominations[i];
                   int rem = j % denominations[i];
                   rem = minCoins[i][rem];

                   minCoins[i][j] = Math.min(minCoins[i-1][j],(div+rem));
               } else if(j >= denominations[i] && i == 0) {
                   minCoins[i][j] = j;
               }
           }
       }
       return minCoins[denominations.length-1][total];
   }
    public static void main(String[] args) {
        CoinChangeMinCoin cc = new CoinChangeMinCoin();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));

        int[] denominations1 = {1, 5, 6,9};
        System.out.println(cc.countChange(denominations1, 10));
    }
}
