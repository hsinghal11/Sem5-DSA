class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n==0) return dp;
        dp[1] = 1;
        if(n==1) return dp;

        for(int i=2; i<=n; i++){
            int cnt = i & 1;
            cnt += dp[i>>1];
            dp[i] = cnt;
        }
        return dp;
    }
}