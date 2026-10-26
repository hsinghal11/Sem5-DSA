class Solution {
    int[][] arr;
    int n;
    int m;
    boolean vis[][];
    public int countIslands(int[][] grid, int k) {
        arr = grid;
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        vis = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] != 0 && vis[i][j] == false) {
                    if(solve(i, j) % k == 0) ans++;
                }
            }
        }
        return ans;
    }

    public long solve(int i, int j){
        if (i < 0 || j < 0 || i >= n || j >= m) return 0;
        if(vis[i][j]) return 0;
        if(arr[i][j] == 0) return 0;
        vis[i][j] = true;
        long ans = arr[i][j];
        //up
        ans += solve(i+1, j);
        //down
        ans += solve(i-1, j);
        //left
        ans += solve(i,j+1);
        //right
        ans += solve(i, j-1);

        return ans;
    }
}