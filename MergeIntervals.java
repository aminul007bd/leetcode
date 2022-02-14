import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int [][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }
        // Sort by ascending starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int []> result = new ArrayList<>();
        // put [1, 3] in a variable
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for(int[] interval: intervals) {
            // Overlapping intervals, move the end if needed
            if(interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void main (String args []) {

        int [][] invervals = {{1,3},{2,6},{8,10},{15,18}};

        Arrays.sort(invervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] inverval: invervals) {
            if(merged.isEmpty() || merged.getLast()[1] < inverval[0]) {
                merged.add(inverval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1],inverval[1]);
            }
        }
//        return merged.toArray(new int[merged.size()][]);
    }
}
