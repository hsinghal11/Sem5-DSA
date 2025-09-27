class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int total = nums[0];
        int max = nums[0];
        int min = nums[0];
        int t_max = nums[0];
        int t_min = nums[0];
        for(int i=1; i<n; i++){
            total += nums[i];
            max = Math.max(max+nums[i], nums[i]);
            min = Math.min(min+nums[i], nums[i]);
            t_max = Math.max(t_max, max);
            t_min = Math.min(t_min, min);
        }
        if(max > 0){
            return Math.max(total-t_min, t_max);
        }else{
            return t_max;
        }
    }
}