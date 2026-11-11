class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long currReq = Math.min(need1, need2);
        long ans = 0;

        if ((long) cost1 + cost2 >= costBoth) {
            ans += currReq * costBoth;

            need1 -= currReq;
            need2 -= currReq;

            if (need1 > 0) {
                ans += (long) need1 * Math.min(cost1, costBoth);
            } else {
                ans += (long) need2 * Math.min(cost2, costBoth);
            }
        } else {
            ans += (long) need1 * cost1;
            ans += (long) need2 * cost2;
        }

        return ans;
    }
}