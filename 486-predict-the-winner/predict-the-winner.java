class Solution {
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for(int n: nums) sum+=n;
        int p1 = Winner(nums, 0, nums.length-1);
        int p2 = sum-p1;
        return p1>=p2?true:false;
    }
    public static int Winner(int[] arr, int i, int j){
        if( i> j) return 0;
        int f = arr[i] + Math.min(Winner(arr, i+2, j), Winner(arr, i+1, j-1));
        int s = arr[j] + Math.min(Winner(arr, i+1, j-1), Winner(arr, i, j-2));
        return Math.max(f,s);
    }
}