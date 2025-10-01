class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int cnt = 0;
        int endIdx = 0;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < intervals[endIdx][1]) {
                cnt++;
            }else{
                endIdx = i;
            }
        }

        return cnt;
    }
}