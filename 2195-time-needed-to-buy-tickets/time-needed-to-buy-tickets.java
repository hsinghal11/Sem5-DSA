class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<int[]> q = new LinkedList<>();
        int ans = 0;
        for(int i=0; i<tickets.length; i++){
            q.offer(new int[]{i, tickets[i]});
        }
        while(true){
            int[] p = q.poll();
            ans++;

            p[1]--;  // decrement ticket count

            if (p[0] == k && p[1] == 0) {
                return ans;
            }

            if (p[1] > 0) {
                q.offer(p);
            }
        }
    }
}