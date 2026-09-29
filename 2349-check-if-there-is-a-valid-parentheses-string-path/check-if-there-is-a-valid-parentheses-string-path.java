class Solution {
    public boolean hasValidPath(char[][] grid) {
        int p = 0;
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == ')') return false;
        Boolean[][][] dp = new Boolean[n][m][n+m];
        return callRe(grid, 0, 0, p, n, m, dp);
    }

    public boolean callRe(char[][] grid, int r, int c, int p, int n, int m, Boolean[][][] dp){
        if(r >= n || c >= m ) return false;

        if(grid[r][c] == '(') p++;
        else p--;

        if (p < 0) return false;

        if(r == n-1 && c == m-1){
            return p == 0;
        }

        
        if(dp[r][c][p] != null) return dp[r][c][p];
        boolean down = callRe(grid, r+1, c, p, n, m, dp);
        boolean right = callRe(grid, r, c+1, p, n, m, dp);

        return dp[r][c][p] = down || right;
    }
}