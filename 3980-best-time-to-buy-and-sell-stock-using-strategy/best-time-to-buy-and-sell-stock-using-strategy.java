class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        // original profit
        long base = 0;
        for (int i = 0; i < n; i++) {
            base += (long) prices[i] * strategy[i];
        }

        // prefix sum of original contributions
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (long) prices[i] * strategy[i];
        }

        // prefix sum of prices
        long[] pricePre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pricePre[i + 1] = pricePre[i] + prices[i];
        }

        long ans = base;

        for (int l = 0; l + k <= n; l++) {
            int mid = l + k / 2;
            int r = l + k;

            // remove original window contribution
            long remove = pre[r] - pre[l];

            // add forced sell contribution (second half)
            long add = pricePre[r] - pricePre[mid];

            long curr = base - remove + add;
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}