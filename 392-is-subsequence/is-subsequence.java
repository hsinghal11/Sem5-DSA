class Solution {
    public boolean isSubsequence(String s, String t) {
        Boolean[][] dp = new Boolean[s.length()+1][t.length()+1];
        return solve(s, t, 0, 0, dp);

    }

    public boolean solve(String s, String t, int i, int j, Boolean[][] dp){
        if (i == s.length()) return true;
        // Base case 2: t is exhausted but s isn't
        if (j == t.length()) return false;

        if(dp[i][j] != null){
            return dp[i][j];
        }
        // Option 1: match current characters
        boolean inc = false;
        if (s.charAt(i) == t.charAt(j)) {
            inc = solve(s, t, i + 1, j + 1, dp);
        }

        // Option 2: skip a char in t
        boolean exc = solve(s, t, i, j + 1, dp);

        return dp[i][j] = ( inc || exc );
    }
}