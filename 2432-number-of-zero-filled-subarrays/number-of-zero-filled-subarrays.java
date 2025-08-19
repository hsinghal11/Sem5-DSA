class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int count = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i]==0){
                ans += count+1; 
                count +=1;
            }else{
                count = 0;
            }
        }
        return ans;
        
    }
}