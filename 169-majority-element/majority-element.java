class Solution {
    public int majorityElement(int[] nums) {
        int voting = 1;
        int elected = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(elected == nums[i]) voting++;
            else{
                voting--;
                if(voting == 0){
                    voting = 1;
                    elected = nums[i];
                }
            }
        }
        return elected;
    }
}