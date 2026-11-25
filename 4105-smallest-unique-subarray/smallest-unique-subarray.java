class Solution {
    static final long MOD = 1_000_000_007L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int si = 1;
        int ei = n;
        int ans = n;
        while (si <= ei) {
            int mi = si + (ei - si) / 2;
            if (hasUnique(nums, mi)) {
                ans = mi;
                ei = mi - 1;
            } else {
                si = mi + 1;
            }
        }
        return ans;
    }

    public boolean hasUnique(int[] nums, int window_size) {
        int n = nums.length;
        long base = 911382323L;

        long[] power = new long[n + 1];
        power[0] = 1;
        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * base) % MOD;
        }

        HashMap<Long, Integer> hash_values = new HashMap<>();

        long current_hash = 0;
        for (int i = 0; i < window_size; i++) {
            current_hash = (current_hash * base + nums[i]) % MOD;
        }
        hash_values.put(current_hash, 1);

        for (int i = 1; i <= n - window_size; i++) {
            // remove the left element
            current_hash = (current_hash - power[window_size - 1] * nums[i - 1]) % MOD;
            if (current_hash < 0) current_hash += MOD;

            // add the new right element
            current_hash = (current_hash * base + nums[i + window_size - 1]) % MOD;
            hash_values.put(current_hash, hash_values.getOrDefault(current_hash, 0) + 1);
        }

        for (long key : hash_values.keySet()) {
            if (hash_values.get(key) == 1) return true;
        }
        return false;
    }
}