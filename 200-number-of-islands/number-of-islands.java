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
        if(i <0 || i> grid.length-1 || j<0 || j>grid[0].length-1 || isVisited[i][j] || grid[i][j] != '1'){
            return;
        }
        isVisited[i][j] = true;
        solve(grid, i+1, j, isVisited);
        solve(grid, i, j+1, isVisited);
        solve(grid, i-1, j, isVisited);
        solve(grid, i, j-1, isVisited);
    }
}