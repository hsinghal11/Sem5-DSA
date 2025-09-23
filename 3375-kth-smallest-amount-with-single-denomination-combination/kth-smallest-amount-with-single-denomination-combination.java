class Solution {
    public long findKthSmallest(int[] coins, int k) {
        // Step 1: Remove redundant coins
        Arrays.sort(coins);
        boolean[] redundant = new boolean[coins.length];
        for (int i = 0; i < coins.length; i++) {
            if (redundant[i]) continue;
            for (int j = i + 1; j < coins.length; j++) {
                if (!redundant[j] && coins[j] % coins[i] == 0) {
                    redundant[j] = true;
                }
            }
        }
        List<Integer> filtered = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (!redundant[i]) filtered.add(coins[i]);
        }
        coins = filtered.stream().mapToInt(Integer::intValue).toArray();

        int n = coins.length;
        int allones = (1 << n);

        // Step 2: Precompute all LCMs
        long[] lcmArr = new long[allones];
        lcmArr[0] = 1;
        for (int mask = 1; mask < allones; mask++) {
            int bit = Integer.numberOfTrailingZeros(mask);
            int prev = mask ^ (1 << bit);
            lcmArr[mask] = calculateLCM(lcmArr[prev], coins[bit]);
        }

        // Step 3: Binary search with tighter bounds
        long l = k;
        long r = (long) k * coins[0];
        long ans = 0;

        while (l <= r) {
            long m = l + (r - l) / 2;
            long c = count(lcmArr, m);

            if (c < k) {
                l = m + 1;
            } else {
                ans = m;
                r = m - 1;
            }
        }
        return ans;
    }

    // count using precomputed lcmArr
    public long count(long[] lcmArr, long m) {
        long cnt = 0;
        for (int mask = 1; mask < lcmArr.length; mask++) {
            long Lcm = lcmArr[mask];
            if (Lcm == 0 || Lcm > m) continue;

            if ((Integer.bitCount(mask) & 1) == 1) {
                cnt += m / Lcm;
            } else {
                cnt -= m / Lcm;
            }
        }
        return cnt;
    }

    public long calculateLCM(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}