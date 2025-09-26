class Solution {
    public int majorityElement(int[] nums) {
        return MooreVoting(nums);
    }
    public static int MooreVoting(int[] nums){
        int elected = 0;
        int voting = 0;
        for (int i = 0; i < nums.length; i++) {
            if(voting ==0 && elected != nums[i]){
                elected = nums[i];
                voting = 1;
            }else if(elected == nums[i]){
                voting++;
            }else{
                voting--;
            }
        }
        return elected;
    }
}