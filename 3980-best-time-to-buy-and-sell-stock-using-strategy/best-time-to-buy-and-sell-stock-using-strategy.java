class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long ans = Long.MIN_VALUE;
        long profit = 0;
        int n = prices.length;
        long[] pre = new long[n];
        for(int i=0; i<n; i++){
            profit += prices[i]*strategy[i];
            pre[i] = profit;
        }
        ans = Math.max(ans, profit);
        for(int time=0; time+k<=n; time++){
            long profit_now = 0;
            if(time-1 >= 0){
                profit_now += pre[time-1];
            }

            for(int i=time+k/2; i<time+k && i<n; i++){
                profit_now += prices[i];
            }

            if(time+k-1<n){
                profit_now += pre[n-1] - pre[time+k-1];
            }
            ans = Math.max(ans,profit_now);
        }
        return ans;

    }
}