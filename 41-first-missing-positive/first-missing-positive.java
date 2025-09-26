class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int ans = 1;
        for(int val:nums){
            if(val == ans) ans++;
        }
        return ans;
    }
}