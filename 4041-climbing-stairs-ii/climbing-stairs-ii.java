class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return findAns(costs, 0, dp);
    }

    public int findAns(int[] costs, int i, int[] dp) {

        if (i == costs.length) return 0;

        if (dp[i] != -1) return dp[i];

        int ans = Integer.MAX_VALUE;

        // Jump i -> i+1
        if (i + 1 <= costs.length) {
            ans = Math.min(ans,
                costs[i] + 1 + findAns(costs, i + 1, dp));
        }

        // Jump i -> i+2
        if (i + 2 <= costs.length) {
            ans = Math.min(ans,
                costs[i + 1] + 4 + findAns(costs, i + 2, dp));
        }

        // Jump i -> i+3
        if (i + 3 <= costs.length) {
            ans = Math.min(ans,
                costs[i + 2] + 9 + findAns(costs, i + 3, dp));
        }

        return dp[i] = ans;
    }
}