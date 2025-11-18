class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        int n = tickets.length;
        int moves = tickets[k];

        // k se phele jo moves ke equal ya chota h vo khtm hoga

        for(int i=0; i<=k; i++){
            ans += Math.min(tickets[i], moves);
        } 

        // k ke baad jo moves -1 ye chota ya equal vo bhi khtm ho jayega to unko bhi add

        for(int i=k+1; i<n; i++){
            ans += Math.min(tickets[i], moves - 1); // moves hamesa >= 1 h isliye 1-1 = 0 hoga min not negative
        }
        return ans;
    }
}