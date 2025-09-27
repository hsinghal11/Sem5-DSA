class Solution {
    public int findKthLargest(int[] nums, int k) {
        // order of n ( by merge sort ka kuch the partition karke)
        // n*logk (good eveyone will accept)
         PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.poll();
    }
}