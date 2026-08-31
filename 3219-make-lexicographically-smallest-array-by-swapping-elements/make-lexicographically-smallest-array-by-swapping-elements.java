class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<nums.length; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
         int[] ans = new int[n];

        int start = 0;
        for (int i = 1; i <= n; i++) {

            // End of current component
            if (i == n || arr[i][0] - arr[i - 1][0] > limit) {

                // Collect indices of this component
                int size = i - start;
                int[] indices = new int[size];

                for (int j = 0; j < size; j++) {
                    indices[j] = arr[start + j][1];
                }

                // Sort original indices
                Arrays.sort(indices);

                // Values are already sorted because arr is sorted
                for (int j = 0; j < size; j++) {
                    ans[indices[j]] = arr[start + j][0];
                }

                start = i;
            }
        }
        return ans;
    }
}