package Leetcode.challenge.Algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class MergeIntervals {

    public MergeIntervals() {
    }

    public int[][] merge(int[][] intervals) {
        int index = 0;
        int counter = 0;
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        for (int i = 0; i < counter+1; i++) {
            for (int j = index + 1; j < intervals.length; j++) {
                if ((intervals[i][1] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) ||
                        (intervals[i][1] >= intervals[j][1] && intervals[j][1] >= intervals[i][0])) {
                    intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                } else {
                    intervals[i + 1][0] = intervals[j][0];
                    intervals[i + 1][1] = intervals[j][1];
                    index = j;
                    counter++;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(intervals, 0, counter+1);
    }
}
