class Solution {
        public boolean hasValidPath(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            if (grid[0][0] == ')') return false;

            // A valid path must contain an even number of cells
            if ((n + m - 1) % 2 != 0) return false;

            Boolean[][][] dp = new Boolean[n][m][n + m];

            return callRe(grid, 0, 0, 0, n, m, dp);
        }

        private boolean callRe(char[][] grid, int r, int c, int p, int n, int m, Boolean[][][] dp) {
            // Update balance
            if (grid[r][c] == '(') {
                p++;
            } else {
                p--;
            }

            // Balance can never become negative
            if (p < 0) return false;

            // Too many '(' to possibly close
            if (p > (n - r) + (m - c) - 1) {
                return false;
            }

            // Destination
            if (r == n - 1 && c == m - 1) {
                return p == 0;
            }

            if (dp[r][c][p] != null) {
                return dp[r][c][p];
            }

            boolean down = false;
            boolean right = false;

            if (r + 1 < n) {
                down = callRe(grid, r + 1, c, p, n, m, dp);
            }

            if (c + 1 < m) {
                right = callRe(grid, r, c + 1, p, n, m, dp);
            }

            return dp[r][c][p] = down || right;
        }
    }