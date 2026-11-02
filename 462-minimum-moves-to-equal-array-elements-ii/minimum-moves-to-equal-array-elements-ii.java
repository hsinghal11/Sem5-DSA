class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length/2;
        int m = nums[n];
        int ans = 0;
        for(int i: nums){
            ans += Math.abs(i-m);
        }
        return ans;
    }
}