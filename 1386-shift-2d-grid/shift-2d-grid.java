class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        k = k%(m*n);
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ans.add(row);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int oldIdx = i*n + j;
                int newIdx = (oldIdx+k)%(m*n);
                int newR = newIdx/n;
                int newC = newIdx%n;
                ans.get(newR).set(newC, grid[i][j]);
            }
        }
        return ans;
    }
}