class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        int n = tickets.length;
        while(tickets[k] > 0){
            for(int i=0; i<n; i++){
                if(tickets[i] == 0){
                    continue;
                }
                tickets[i]--;
                ans++;
                if(i ==k && tickets[i] == 0) return ans;
            }
        }
        return ans;
    }
}