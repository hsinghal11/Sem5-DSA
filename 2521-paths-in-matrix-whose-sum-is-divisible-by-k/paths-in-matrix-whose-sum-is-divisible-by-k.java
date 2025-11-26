class Solution {
    static int MOD = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k];
        for(int[][] dpi : dp) 
            for(int[] dpin : dpi) 
                Arrays.fill(dpin,-1);
        return solve(grid, k, 0, 0, 0, dp);
    }
    public int solve(int[][] grid, int k, int r, int c, int sum, int[][][] dp){
        if(r >= grid.length || c >=grid[0].length){
            return 0;
        }
        if(r == grid.length-1 && c == grid[0].length-1 && (sum+grid[r][c])%k == 0){
            return 1;
        }
        sum = (sum + grid[r][c]) % k;
        if(dp[r][c][sum] !=-1) return dp[r][c][sum];
        int down = solve(grid,k,r+1,c,sum, dp);
        int right = solve(grid,k,r,c+1,sum, dp);
        return dp[r][c][sum] = (down+right)%MOD;
    }
}