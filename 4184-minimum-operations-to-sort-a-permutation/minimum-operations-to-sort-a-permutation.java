class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int idx0 = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx0 = i;
                break;
            }
        }

        boolean normal = true;
        boolean reversed = true;

        for (int i = 0; i < n; i++) {
            // Check increasing circular order
            if (nums[(idx0 + i) % n] != i) {
                normal = false;
            }

            // Check decreasing circular order
            if (nums[(idx0 - i + n) % n] != i) {
                reversed = false;
            }
        }

        if (!normal && !reversed) {
            return -1;
        }

        // Already sorted by circular rotation
        if (normal) {
            return Math.min(idx0, n - idx0 + 2);
        }

        // Reverse once, then rotate
        int rotations = (n - 1 - idx0 + n) % n;
        return 1 + Math.min(rotations, n - rotations);
    }
}
