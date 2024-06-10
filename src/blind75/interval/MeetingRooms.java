package src.blind75.interval;

import java.util.*;

/*
Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
Meetings: [[1,4], [2,5], [7,9]]
Output: 2

 */
public class MeetingRooms {
    public int findMinimumMeetingRooms(List<Meeting> meetings) {
        int minRooms = 0;

        if(meetings==null || meetings.size() < 1)
            return minRooms;

        Collections.sort(meetings,(a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Meeting> meetingRoom = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));

        for(Meeting meeting : meetings ) {
            while(!meetingRoom.isEmpty() && meetingRoom.peek().end <= meeting.start) {
                meetingRoom.poll();
            }
            meetingRoom.add(meeting);
            minRooms = Math.max(minRooms,meetingRoom.size());
        }


        return minRooms;
    }
    public static void main(String[] args) {
        MeetingRooms sol = new MeetingRooms();
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        int result = sol.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = sol.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = sol.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = sol.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}
