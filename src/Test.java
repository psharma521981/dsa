package src;

import java.util.ArrayList;
import java.util.List;
/*

Problem 1 - Amazon - Screening
Give price lists of items. Need to make sure at anytime with limit K items, list price cannot go beond threashold

Problem 2 - Find every second, how many request available in queue and provided the waiting time of request in the queue.
pick up in order of FIFO.

 */
public class Test {

    public static void main(String[] s) {
        List<Integer> prices =new ArrayList<>();
        prices.add(9);
        prices.add(6);
        prices.add(7);
        prices.add(2);
        prices.add(7);
        prices.add(2);
        int k = 2;
        int threshold = 13;

        System.out.println(reduceGifts(prices,k,threshold));
    }
    public static int reduceGifts(List<Integer> prices, int k, int threshold){
        if(prices==null || prices.size() < k)
            return 0;

        int cartSize = 0;
        int bucketSum = 0;
        int left = 0;
        int right = 0;
        List<Integer> itemsRemoved = new ArrayList<>();
        while(right < prices.size()) {
            cartSize++;
            bucketSum+=prices.get(right);
            if(cartSize>=k) {
                while(bucketSum > threshold) {
                    bucketSum -= prices.get(left);
                    itemsRemoved.add(prices.get(left));
                    left++;
                    cartSize--;
                }
            }
            right++;
        }
        return (itemsRemoved.size()==prices.size()) ? prices.size() - k : itemsRemoved.size();
    }
    /*
    public static List<Integer> findRequestsInQueue(List<Integer> wait) {

        //Validate input
       if(wait==null || wait.size() < 1)
            return null;

       int secondsElapse = 0;
       List<Integer> expiredRequests = new ArrayList<>();

       //Loop over every seond until end of queue
       for(int i=1;i<=wait.size();i++) {
           secondsElapse++;
        int expiredRequestCount = 0;
        //check every second non-expired requests
        for(int j =0;j<wait.size();j++) {
            if(wait.get(j) !=-1) {
                if(wait.get(j) >= secondsElapse) {
                  expiredRequestCount++;
                } else {
                    wait.set(j, -1);
                }
            }
        }
         expiredRequests.add(expiredRequestCount);
       }
       return expiredRequests;
    }
     */
}
