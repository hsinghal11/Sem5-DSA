class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        int ans = 1;
        int prev = nums[0];
        while(i < nums.length && j < nums.length){
            if(nums[i] == prev){
                i++;
            }else{
                nums[j++] = nums[i];
                prev = nums[i];
                ans++;
            }
        }
        return ans;
    }
}