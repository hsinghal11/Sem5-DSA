class Solution {
    public int maxProfit(int[] nums) {
        int b = nums[0];
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > b){
                p+=nums[i]-b;
            }
            b=nums[i];
        }
        return p;
    }
}