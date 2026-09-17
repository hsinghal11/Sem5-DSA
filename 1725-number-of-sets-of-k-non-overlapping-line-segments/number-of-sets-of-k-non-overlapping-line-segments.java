class Solution {
    int MOD = 1_000_000_007;
    public int numberOfSets(int n, int K) {
       int[][] dp = new int[n + 1][K + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for(int k=1; k<=K; k++){
            int[] prevRowSum = new int[n+1];

            for (int i = n-1; i >= 0; i--) {
                prevRowSum[i] = (prevRowSum[i+1] + dp[i][k-1]) % MOD;
            }

            for (int i = n-1; i >= 0 ; i--) {
                int take = prevRowSum[i+1];
                int skip = dp[i+1][k];
                
                dp[i][k] = (take+skip)%MOD;
            }
        }
        return dp[0][K];
    }
}