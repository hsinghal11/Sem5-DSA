class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = Integer.bitCount(i);
        }
        return dp;
    }
}