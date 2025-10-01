class Solution {
    public int jump(int[] nums) {
        int c = 0;
        int mJ = 0;
        int eJ = 0;
        for(int i=0; i<nums.length-1; i++){
            mJ = Math.max(mJ, nums[i]+i);
            if(i == eJ){
                c++;
                eJ = mJ;
            }
        }
        return c;
    }
}