class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]){
                    solve(grid, i, j, isVisited);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void solve(char[][] grid, int i, int j, boolean[][] isVisited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        isVisited[i][j] = true;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curr = cur[0];
            int curc = cur[1];
            for(int[] dir: directions){
                int newRow = curr + dir[0];
                int newCol = curc + dir[1];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                    if (grid[newRow][newCol] == '1' && !isVisited[newRow][newCol]) {
                        isVisited[newRow][newCol] = true;
                        q.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }
}