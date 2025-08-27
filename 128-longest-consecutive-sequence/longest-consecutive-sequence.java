class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for (int i : nums) {
            set.add(i);
        }

        for (int i : set) {
            // only start counting if i is the beginning of a sequence
            if (!set.contains(i - 1)) {
                int c = 0;
                int key = i;
                while (set.contains(key)) {
                    c++;
                    key++;
                }
                ans = Math.max(ans, c);
            }
        }
        return ans;
    }
}
