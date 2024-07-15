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
/*

Apple

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
        import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
// StartTime and endTime
//Video id, Start timw, End
class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public Map<Pair<String, String>, Integer> calculateOverlappingEvents(Event[] events, String videoId) {
        /*


         */
        //Validate

        if(events == null || events.length < 2)
            return null;

        Arrays.sort(events,(a,b) -> Integer.compare(a.startVideoTime,b.startVideoTime));  //N + n log N

        //Assuming we campute actual seconds of start & end time from start of video
        int startTime;
        int endTime;

        int index = 0;
        Map<Pair<String, String>, Integer> calculateFrequency = new HashMap();
        boolean foundFirstEvent = false;

        while(index < events.length) {

            if(foundFirstEvent) {
                int frequency = 0;
                //Found the overlapping event for videoId for subsequent video id's
                while(index < events.length && events[index].videoId == videoId && events[index].startVideoTime <= endTime) {
                    startTime = Math.min(events[index].startVideoTime,startTime);
                    endTime = Math.max(events[index].endVideoTime,endTime);
                    frequency++;
                    index++;
                }
                //Add the calculated frequency with respect to pair of start,end time
                calculateFrequency.put(new Pair(startTime,endTime),frequency);
                index++;
            } else {
                //This is to check & initialize the first event which match the video id
                if(events[index].videoId == videoId) {
                    foundFirstEvent = true;
                    //Assuming we campute actual seconds of start & end time from start of video
                    //If start time only given then need to calculate end time using timestamp & start of seconds
                    startTime = events[0].startVideoTime;
                    endTime =   events[0].endVideoTime;
                }
            }
        }

    }
}




// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!

// // Datastructure design

/*

Event :
  {
    "videoId": xyz,
    "startTime": "TIMESTAMP_1",
    "endTime": "TIMESTAMP_2",
    "startVideoTime": "3 sec"
  }


32 minute video ---> 0 sec ---> 32 minute

DB Entity:
  {
     "videoId": xyz,
     "videoDuration": 32
  }

Output ----->  Which part of the video is most watched ?

videoId ----> Non overlapping intervals ----> Frequency of merge done

0 sec to 2 minutes ---> 5 events
14 minutes to 21 minutes ---> 12 events


 //1) Validate the input
//2 Sort over the starttime
//3) traverse through all the events and compare overlapping event.
//If overlapping time, count of overlapping events in respect to video videoId
//If no overlaped found capture some dummy response - 0 events

 */
