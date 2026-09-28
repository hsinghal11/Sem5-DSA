class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int first = nums[i];
            for (int j = i+1; j < n; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int second = nums[j];
                int si = j + 1;
                int ei = n - 1;
                while (si < ei) {
                    long l = (long) first + second + nums[si] + nums[ei];
                    if ( l == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[si], nums[ei]));
                        ei--;
                        si++;

                        while (si < ei && nums[ei] == nums[ei + 1]) ei--;
                        while (si < ei && nums[si] == nums[si - 1]) si++;

                    } else if (l > target) {
                        ei--;
                    } else {
                        si++;
                    }
                }
            }
        }
        return ans;
    }
}