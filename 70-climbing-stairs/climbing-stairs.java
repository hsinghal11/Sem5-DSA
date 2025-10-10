class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solveStair(n, 0, dp);
    }

    public int solveStair(int n, int c, int[] dp){
        if(n==c){
            return 1;
        }
        if(n < c) return 0;
        if(dp[c] != -1){
            return dp[c];
        }
        int call1 = solveStair(n, c+1, dp);
        int call2 = solveStair(n, c+2, dp);
        return dp[c] = call1 + call2;
    }
}