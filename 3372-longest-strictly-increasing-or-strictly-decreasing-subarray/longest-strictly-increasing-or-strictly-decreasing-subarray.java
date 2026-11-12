class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;

        int maxI = 1;
        int maxD = 1;

        for(int i = 1; i< nums.length; i++){
            if(nums[i-1] > nums[i]){
                dec++;
                maxD = Math.max(maxD, dec);
                inc = 1;
            }else if(nums[i-1] < nums[i]){
                inc++;
                maxI = Math.max(maxI, inc);
                dec = 1;
            }else{
                inc = 1;
                dec = 1;
            }
        }
        return Math.max(maxI, maxD);
    }
}