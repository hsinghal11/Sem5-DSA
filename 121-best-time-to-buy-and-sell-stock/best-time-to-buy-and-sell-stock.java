class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int m = prices[n-1];
        int ans = 0;
        for(int i=n-2; i>=0; i--){
            ans = Math.max(ans, m-prices[i]);
            if(prices[i] > m){
                m = prices[i];
            }
        }
        return ans;
    }
}