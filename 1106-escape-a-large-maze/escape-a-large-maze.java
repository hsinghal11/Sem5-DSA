class Solution {
    private static final int LIMIT = 20000;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> block = new HashSet<>();
        for (int[] b : blocked) {
            block.add(hash(b[0], b[1]));
        }

        return bfs(source, target, block) && bfs(target, source, block);
    }

    private boolean bfs(int[] start, int[] finish, Set<Long> block) {
        Set<Long> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited.add(hash(start[0], start[1]));

        while (!q.isEmpty() && visited.size() <= LIMIT) {
            int[] cur = q.poll();
            if (cur[0] == finish[0] && cur[1] == finish[1]) return true;

            for (int[] d : DIRS) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if (nx < 0 || ny < 0 || nx >= 1_000_000 || ny >= 1_000_000)
                    continue;

                long key = hash(nx, ny);
                if (block.contains(key) || visited.contains(key)) continue;

                visited.add(key);
                q.add(new int[]{nx, ny});
            }
        }
        return visited.size() > LIMIT;
    }

    private long hash(int x, int y) {
        return ((long)x << 32) | y;
    }
}
