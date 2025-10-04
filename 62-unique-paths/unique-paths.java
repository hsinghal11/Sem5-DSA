class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        int[][] dp = new int[m+1][n+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return path(grid, 0, 0, dp);
    }
    public int path(int[][] grid,int m, int n, int[][] dp){
        if(m == grid.length-1 && n== grid[0].length-1){
            return 1;
        }
        if(m<0 || m>=grid.length || n<0|| n>grid[0].length){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int p = path(grid, m+1, n, dp);
        int r = path(grid, m, n+1, dp);
        return dp[m][n] = p+r;
    }
}