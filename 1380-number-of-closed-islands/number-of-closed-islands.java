class Solution {
    int[][] arr;
    int n;
    int m;
    boolean vis[][];
    public int closedIsland(int[][] grid) {
        arr = grid;
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        vis = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0 && vis[i][j] == false) {
                    if(solve(i, j)) ans++;
                }
            }
        }
        return ans;
    }

    public boolean solve(int i, int j){
        if (i < 0 || j < 0 || i >= n || j >= m) return false;
        if(vis[i][j]) return true;
        if(arr[i][j] == 1) return true;
        vis[i][j] = true;
        boolean ans = true;
        //up
        ans &= solve(i+1, j);
        //down
        ans &= solve(i-1, j);
        //left
        ans &= solve(i,j+1);
        //right
        ans &= solve(i, j-1);

        return ans;
    }
}