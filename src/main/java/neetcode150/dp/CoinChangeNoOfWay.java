package src.neetcode150.dp;

public class CoinChangeNoOfWay {

    public int countChange(int[] denominations, int total) {

       int[][] claculateCoinChange = new int[denominations.length][total+1];

       for(int i=0;i<denominations.length;i++) {
           for(int j=0;j<total+1;j++) {
               if(j==0) {
                   claculateCoinChange[i][j] = 1;
               } else {
                   if(i > 0) {
                       if (denominations[i] > total) {
                           claculateCoinChange[i][j] = claculateCoinChange[i-1][j];
                       } else {
                           int rem = total - denominations[i];
                           claculateCoinChange[i][j] = claculateCoinChange[i-1][j] + claculateCoinChange[i][rem];
                       }
                   } else {
                       claculateCoinChange[i][j] = total % denominations[i];
                   }
               }
           }
       }
       return claculateCoinChange[denominations.length-1][total];
    }
    public static void main(String[] args) {
        CoinChangeNoOfWay cc = new CoinChangeNoOfWay();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
    }
}
