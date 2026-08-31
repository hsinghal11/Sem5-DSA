class Solution {
    public int minimumDeletions(int[] nums) {
        int mi = -1;
        int mx = -1;
        int mii = Integer.MAX_VALUE;
        int mxx = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < mii) {
                mii = nums[i];
                mi = i;
            }

            if(nums[i] > mxx) {
                mxx = nums[i];
                mx = i;
            }
        }
        int d = Math.abs(mx-mi)-1;
        return  Math.min(
                Math.min(nums.length-d, Math.max(mi, mx)+1),
                (nums.length - Math.min(mi, mx))      
        );
    }
}