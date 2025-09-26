class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k+1];
        int n = nums.length;
         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        // initial window
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        ans[0] = pq.peek()[0];
        
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            
            // remove elements out of window
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}