package src.neetcode150.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    /*
    Given a list of time intervals during which meetings are scheduled, determine the minimum number of meeting rooms that are required to ensure that none of the meetings overlap in time.

     Input: [[10, 15], [20, 25], [30, 35]]
Expected Output: 1

Input: [[10, 20], [15, 25], [24, 30]]
Expected Output: 2
     */
    public int minMeetingRooms(int[][] intervals) {

        if(intervals==null || intervals.length < 1)
            return 0;

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int minRoom = 0;
        PriorityQueue<int[]> meetingRooms = new PriorityQueue<>((a, b) -> Integer.compare(a[1],b[1]));
        for(int[] interval:intervals) {

            while(!meetingRooms.isEmpty() && meetingRooms.peek()[1] <= interval[0])
                meetingRooms.poll();

            meetingRooms.add(interval);
            minRoom = Math.max(minRoom,meetingRooms.size());

        }
        return minRoom;
    }
    public static void main(String[] args) {
        MeetingRoomsII sol = new MeetingRoomsII();
        System.out.println(sol.minMeetingRooms(new int[][]{{10, 15}, {20, 25}, {30, 35}})); // 1
        System.out.println(sol.minMeetingRooms(new int[][]{{10, 20}, {15, 25}, {24, 30}})); // 2
        System.out.println(sol.minMeetingRooms(new int[][]{{10, 20}, {20, 30}})); // 1
    }
}
