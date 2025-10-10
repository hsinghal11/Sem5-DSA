class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
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