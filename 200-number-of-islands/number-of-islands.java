class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    solve(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void solve(char[][] grid, int i, int j) {
        if(i <0 || i> grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        solve(grid, i+1, j);
        solve(grid, i, j+1);
        solve(grid, i-1, j);
        solve(grid, i, j-1);
    }
}