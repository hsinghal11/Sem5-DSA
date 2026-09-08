class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length())
            return 0;
        int[][] dp = new int[s.length()][t.length()];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return solveDis(s, t, 0, 0, dp);
    }

    private int solveDis(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = solveDis(s, t, i + 1, j, dp); // don't pick

        if (s.charAt(i) == t.charAt(j)) {
            ans += solveDis(s, t, i + 1, j + 1, dp); // pick
        }

        return dp[i][j] = ans;
    }
}