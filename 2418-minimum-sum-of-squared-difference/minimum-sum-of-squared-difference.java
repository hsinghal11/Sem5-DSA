class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 100000;
        // count[i] stores how many pairs have an absolute difference of i
        long[] count = new long[maxDiff + 1]; 
        
        for (int i = 0; i < n; i++) {
            count[Math.abs(nums1[i] - nums2[i])]++;
        }

        long totalK = (long) k1 + k2;

        // Process from the largest possible difference down to 1
        for (int d = maxDiff; d > 0; d--) {
            if (count[d] == 0) continue;

            // If we have enough k to reduce ALL elements of difference 'd' to 'd-1'
            if (totalK >= count[d]) {
                totalK -= count[d];
                count[d - 1] += count[d];
                count[d] = 0;
            } else {
                // We can only reduce some of them
                long reduceAllBy = totalK / count[d];
                long remainder = totalK % count[d];

                if (reduceAllBy > 0) {
                    count[d - (int)reduceAllBy] += (count[d] - remainder);
                    count[d - (int)reduceAllBy - 1] += remainder;
                } else {
                    count[d] -= remainder;
                    count[d - 1] += remainder;
                }
                totalK = 0;
                break; // No more k left to use
            }
        }

        // Calculate the final sum of squares
        long ans = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                ans += count[d] * (long) d * d;
            }
        }
        
        return ans;
    }
}
