/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.end - b.end);
        int prevInterval = 0;
        for (int currInterval = 1; currInterval < intervals.size(); currInterval++) {
            if (intervals.get(currInterval).start < intervals.get(prevInterval).end) {
                return false;
            }
            prevInterval = currInterval;
        }

        return true;
    }
}
