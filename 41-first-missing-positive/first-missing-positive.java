class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] f = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= nums.length && nums[i] > 0){
                f[nums[i]]++;
            }
        }
        int ans = 1;
        for(int i=1; i<f.length; i++){
            if(ans == i && f[i] != 0) ans++;
        }
        return ans;
    }
}