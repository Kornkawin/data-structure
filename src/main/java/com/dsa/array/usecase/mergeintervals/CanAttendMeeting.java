package com.dsa.array.usecase.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class CanAttendMeeting {
    // Time: O(n log n)
    // Space: O(1)
    private static boolean canAttendMeetings(int[][] intervals) {
        // sorting intervals by start time O(n log n)
        // Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); // faster
        // check overlapping O(n)
        for (int i = 0; i < intervals.length - 1; i++) {
            int endTime = intervals[i][1];
            int nextStartTime = intervals[i+1][0];
            if (endTime > nextStartTime) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals = {{7,10},{2,4}};
        boolean sol = canAttendMeetings(intervals);
        System.out.println("Ans: "+sol);
    }
}
