class Solution {
    public int firstMissingPositive(int[] nums) {
        /* extra space
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
        */

        /** optimized solution */
        int n = nums.length;
        for(int i=0; i<n; i++){
            while(nums[i] >0 && nums[i] <n && nums[i] != nums[nums[i]-1]){
                swap(nums,i, nums[i]-1);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
