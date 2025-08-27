class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int i=0; i<queries.length; i++){
            int idx = queries[i][0];
            long ri = queries[i][1];
            long ki = queries[i][2];
            long vi = queries[i][3];
            while(idx <= ri){
                nums[idx] = (int)((nums[idx]*(long)vi) % (1000000007L));
                idx += ki;
            }
        }
        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }
        return ans;
    }
}