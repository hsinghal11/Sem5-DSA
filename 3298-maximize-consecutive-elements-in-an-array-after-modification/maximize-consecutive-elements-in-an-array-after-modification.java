class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
    Map<Integer, Integer> dp = new HashMap<>();
    int ans = 0;

    for (int x : nums) {
        // must do x+1 first, using the OLD dp[x]
        int inc = dp.getOrDefault(x, 0) + 1;
        dp.merge(x + 1, inc, Math::max);

        // then x, using dp[x-1]
        int same = dp.getOrDefault(x - 1, 0) + 1;
        dp.merge(x, same, Math::max);

        ans = Math.max(ans, Math.max(inc, same));
    }
    return ans;
    }
}