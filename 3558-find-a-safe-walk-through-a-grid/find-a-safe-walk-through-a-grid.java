class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        boolean[][] vis = new boolean[n][m];

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[] { 0, 0, health });

        while (!dq.isEmpty()) {
            int[] po = dq.pollFirst(); // <-- remove, not just peek
            int i = po[0];
            int j = po[1];
            int h = po[2];

            if (vis[i][j])
                continue;
            vis[i][j] = true;

            h -= grid.get(i).get(j);
            if (i == n - 1 && j == m - 1) {
                return h > 0; // check after marking, health already reflects entering this cell
            }

            if (h <= 0)
                continue; // no point expanding a dead path

            int[] r = { -1, 1, 0, 0 };
            int[] c = { 0, 0, -1, 1 };

            for (int co = 0; co < 4; co++) {
                int nr = i + r[co];
                int nc = j + c[co];
                if (nr < 0 || nc < 0 || nr > n - 1 || nc > m - 1)
                    continue;
                if (vis[nr][nc])
                    continue;
                if (grid.get(nr).get(nc) == 0)
                    dq.addFirst(new int[] { nr, nc, h });
                else
                    dq.addLast(new int[] { nr, nc, h });
            }
        }
        return false;
    }
}