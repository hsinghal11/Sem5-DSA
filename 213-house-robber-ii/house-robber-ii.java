class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ans1 = solve(nums, 0, nums.length-2);
        int ans2 = solve(nums, 1, nums.length-1);
        return Math.max(ans1, ans2);
    }
    public int solve(int[] nums, int si, int ei){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Robber(nums, si, ei, dp);
    }
    public int Robber(int[] arr, int i, int j, int[] dp){
        if(i > j){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int rob = arr[i] + Robber(arr, i+2, j, dp);
        int dont_rob = Robber(arr, i+1, j, dp);
        return dp[i] = Math.max(rob, dont_rob);
    }
}