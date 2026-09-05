class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] mi = new int[n];
        int[] mx = new int[n];
        mx[0] = nums[0];
        mi[n-1] = nums[n-1];
        for(int i=1; i<n; i++){
            mx[i] = Math.max(mx[i-1], nums[i]);
            mi[n-i-1] = Math.min(mi[n-i], nums[n-i-1]);
        }
        
        for(int i=0; i<n; i++){
            if(mx[i] - mi[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}