import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsII_253 {
    public int minMeetingRooms(int[][] intervals) {
        if( intervals.length == 0) return 0;
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        // Sort the intervals by end time
        Arrays.sort(
                end,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });

        Arrays.sort(
                start,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });

        // The two pointer in the algorithm
        int startPointer = 0, endPointer = 0;

        // Variable to keep track of maximum number of rooms used.
        int usedRooms = 0;
        while (startPointer < intervals.length) {
            // if there is a meeting that has ended by teh time
            if(start[startPointer] >= end[endPointer]) {
                usedRooms -= 1;
                endPointer += 1;
            }
            // We do this irrespective of whether a room frees up or not.
            // If a room get free, then this used_rooms += 1 wouldn't affect. used_rooms would
            // remain the same in that case. If no room was free, then this would increase used_rooms
            usedRooms += 1;
            startPointer -= 1;
        }

        return usedRooms;
    }
}

















