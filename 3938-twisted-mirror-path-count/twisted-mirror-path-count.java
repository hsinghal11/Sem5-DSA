class Solution {
    int[][] arr;
    int n;
    int m;
    int[][][] dp;
    static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        arr = grid;
        n = grid.length;
        m = grid[0].length;
        dp = new int[n + 1][m + 1][3];
        for (int[][] a : dp) {
            for (int[] b : a)
                Arrays.fill(b, -1);
        }
        return findAns(0, 0, 2);
    }

    private int findAns(int i, int j, int last) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;
        if (i == n - 1 && j == m - 1)
            return 1;

        if (dp[i][j][last] != -1)
            return dp[i][j][last];

        int ans = 0;

        if (arr[i][j] == 1) {
            if (last == 0)
                ans = (ans + findAns(i + 1, j, 1)) % MOD;

            if (last == 1)
                ans = (ans + findAns(i, j + 1, 0)) % MOD;

        } else {
            // right
            ans = (ans + findAns(i, j + 1, 0)) % MOD;

            // down
            ans = (ans + findAns(i + 1, j, 1)) % MOD;
        }
        return dp[i][j][last] = ans;
    }
}