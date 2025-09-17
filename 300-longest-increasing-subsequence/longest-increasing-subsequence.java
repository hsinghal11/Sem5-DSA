class Solution {
    public int lengthOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
        int len = 1;
        dp[0] = arr[0];
        for (int i = 0; i < dp.length; i++) {
            if (arr[i] > dp[len -1]){
                dp[len] = arr[i];
                len++;
            }else {
                int idx = BinarySearch(dp, 0, len-1, arr[i]);
                dp[idx] = arr[i];
            }
        }
        return len;
    }
    public int BinarySearch(int[] dp, int start, int end, int target){
        int ans = 0;
        while (start <= end){
            int mid = start + (end-start)/2;
            if(dp[mid] >= target){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}