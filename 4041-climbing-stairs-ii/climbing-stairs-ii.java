class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;

            // Jump 1
            dp[i] = Math.min(dp[i],
                costs[i] + 1 + dp[i + 1]);

            // Jump 2
            if (i + 2 <= n) {
                dp[i] = Math.min(dp[i],
                    costs[i + 1] + 4 + dp[i + 2]);
            }

            // Jump 3
            if (i + 3 <= n) {
                dp[i] = Math.min(dp[i],
                    costs[i + 2] + 9 + dp[i + 3]);
            }
        }

        return dp[0];
    }
}