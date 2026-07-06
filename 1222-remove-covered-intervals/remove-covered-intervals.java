class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int covered = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j && intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
                    covered++;
                    break;
                }
            }
        }

        return n - covered;
    }
    }
