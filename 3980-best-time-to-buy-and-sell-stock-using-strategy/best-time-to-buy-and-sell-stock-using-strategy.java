class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long ans = Long.MIN_VALUE;
        long profit = 0;
        int n = prices.length;
        long[] pre = new long[n];
        long[] pre1 = new long[n];
        pre1[0] = prices[0];
        for(int i=0; i<n; i++){
            profit += prices[i]*strategy[i];
            pre[i] = profit;
        }
        for(int i=1; i<n; i++){
            pre1[i] = pre1[i-1]+prices[i];
        }
        ans = Math.max(ans, profit);
        for(int time=0; time+k<=n; time++){
            long profit_now = 0;
            if(time-1 >= 0){
                profit_now += pre[time-1];
            }

            int from = time + k / 2;
            int to = time + k - 1;
            profit_now += pre1[to] - (from > 0 ? pre1[from - 1] : 0);

            if(time+k-1<n-1){
                profit_now += pre[n-1] - pre[time+k-1];
            }
            ans = Math.max(ans,profit_now);
        }
        return ans;

    }
}