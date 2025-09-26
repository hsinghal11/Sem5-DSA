class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k+1];
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
         for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            
            dq.offerLast(i);
            
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
         }
        return ans;
    }
}