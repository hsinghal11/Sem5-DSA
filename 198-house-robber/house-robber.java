class Solution {
    public int rob(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return Robber(arr, arr.length-1, dp);
    }
    public int Robber(int[] arr, int i, int[] dp){
        if(i < 0){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int rob = arr[i] + Robber(arr, i-2, dp);
        int dont_rob = Robber(arr, i-1, dp);
        return dp[i] = Math.max(rob, dont_rob);
    }
}