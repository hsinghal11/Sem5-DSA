class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int lastUsed=Integer.MIN_VALUE;
        int count=0;

        for(int num:nums){
            int minAllowed=num-k;
            int maxAllowed=num+k;
            if(lastUsed<minAllowed){
                count++;
                lastUsed=minAllowed;
            }
            else if(lastUsed<maxAllowed){
                count++;
                lastUsed++;
            }

        }
        return count;
    }
}