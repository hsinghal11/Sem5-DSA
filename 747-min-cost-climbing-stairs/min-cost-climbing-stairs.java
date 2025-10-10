class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int  n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(cost, dp, 0, 0);
    }

    public int solve(int[] cost, int[] dp, int ans, int s){
        if(s >= cost.length-1){
            return ans;
        }
        if(dp[s] != -1) return dp[s];
        int call1 =  cost[s]+ solve(cost, dp,ans, s+1);
        int call2 =  cost[s+1] +solve(cost, dp, ans, s+2);
        return dp[s] = Math.min(call1, call2);
    }
}