class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n]; 
        int i = 0;
        int j = 1;
        for(int k=0; k<n; k++){
            ans[i] = nums[k];
            ans[j] = nums[n+k];
            i+=2;
            j+=2;
        }
        return ans;
    }
}