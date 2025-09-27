class Solution {
    public int search(int[] nums, int target) {
        return BS(nums,nums.length,target);
    }
    public static int BS(int[] arr, int n, int t){
        int l = 0;
        int r = n-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(arr[m] == t) return m;
            else if(arr[m] <= arr[r]){
                if(arr[m] <= t && arr[r]>=t) l = m+1;
                else r = m-1;
            }else{
                if(arr[l]<=t && arr[m]>=t) r = m-1;
                else l = m+1;
            }
        }
        return -1;
    }
}
