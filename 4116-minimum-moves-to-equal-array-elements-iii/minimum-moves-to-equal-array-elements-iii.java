class Solution {
    public int minMoves(int[] nums) {
        int m = -1;
        for(int i: nums) m = Math.max(i, m);
        final int max = m; 
        return Arrays.stream(nums).map(f -> Math.abs(f-max)).sum();

    }
}