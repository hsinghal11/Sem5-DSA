class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int cnt = 1;
        int endIdx = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[endIdx][1]) {
                cnt++;
                endIdx = i;
            }
        }

        return n-cnt;
    }
}