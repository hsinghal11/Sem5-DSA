class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        boolean[][] isVisited = new boolean[n][m];
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};

        int size = q.size();
        int count = 0;
        int ans = 0;

        while(!q.isEmpty()){

            // level boundary check
            if(count == size){
                size = q.size();
                count = 0;
                ans++;
            }

            int[] r = q.poll();
            count++;

            if(isVisited[r[0]][r[1]]){
                continue;
            }
            isVisited[r[0]][r[1]] = true;

            for(int i=0; i<4; i++){
                int nr = r[0] + row[i];
                int nc = r[1] + col[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m &&
                   !isVisited[nr][nc] && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && !isVisited[i][j]){
                    return -1;
                }
            }
        }

        return ans < 0 ? 0 : ans;
    }
}
