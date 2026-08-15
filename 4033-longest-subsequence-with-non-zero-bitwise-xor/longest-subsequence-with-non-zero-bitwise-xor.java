class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 1;
        int c0 = 0;
        for(int i: nums){
            xor ^= i;
            if(i==0) c0++;
        }
        xor ^= 1;
        if(xor != 0) return nums.length;
        if(c0 == nums.length) return 0;
        return nums.length-1;
    }
}