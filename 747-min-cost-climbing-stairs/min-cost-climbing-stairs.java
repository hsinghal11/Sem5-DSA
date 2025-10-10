class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int  n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }

    // public int solve(int[] cost, int[] dp, int s){
    //     if(s >= cost.length-1){
    //         return 0;
    //     }
    //     if(dp[s] != -1) return dp[s];
    //     int call1 =  cost[s]+ solve(cost, dp, s+1);
    //     int call2 =  cost[s+1] +solve(cost, dp, s+2);
    //     return dp[s] = Math.min(call1, call2);
    // }
}