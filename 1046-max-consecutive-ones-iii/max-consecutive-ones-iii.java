class Solution {
    public int longestOnes(int[] nums, int k) {
        int si = 0, ei = 0, ans = 0, n = nums.length, flip = 0;
        while(ei < n){
            if(nums[ei] == 0) flip++;

            while(flip > k){
                if(nums[si] == 0) flip--;
                si++;
            }

            ans = Math.max(ans, ei-si+1);
            ei++;
        }
        return ans;
    }
}