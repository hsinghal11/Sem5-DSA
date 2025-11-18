class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges to queue + count fresh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0; // No fresh orange to rot

        int minutes = 0;
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};

        // Step 2: BFS level-by-level
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottenThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                for (int k = 0; k < 4; k++) {
                    int nr = r + row[k];
                    int nc = c + col[k];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Mark rotten
                        q.offer(new int[] { nr, nc });
                        fresh--;
                        rottenThisRound = true;
                    }
                }
            }

            if (rottenThisRound) minutes++;
        }

        return (fresh == 0) ? minutes : -1;
    }
}
