package merge_interval;

import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};
public class MinimumMeetingRooms {
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        int minRooms = 0;

        //Validate input
        //Sort the input on the basis of start time
        //Create min heap to store earliest finish time of meeting
        //if new time not is then then peek of min heap then store in heap
        //or else remove peek and store new time
        //evry time check size of the queue ans tore the max

        if(meetings == null || meetings.isEmpty())
            return minRooms;

        Collections.sort(meetings,(a,b) -> a.start - b.start);
        PriorityQueue<Meeting> queue = new PriorityQueue<>(meetings.size(), (a,b) -> Integer.compare(a.end, b.end));

        for(Meeting m:meetings) {

            if(!queue.isEmpty()) {
                if(queue.peek().end <= m.start) {
                    queue.poll();
                }
            }
            queue.add(m);
            minRooms = Math.max(minRooms,queue.size());
        }
        return minRooms;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }

}
