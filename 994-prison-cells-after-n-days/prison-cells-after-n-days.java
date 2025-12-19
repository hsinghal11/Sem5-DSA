class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        n = (n-1)%14 + 1;

        for(int j=n; j>0; j--){
            int arr[] = new int[8];
            for(int i=1; i<7; i++){
                if(cells[i-1] == cells[i+1]) arr[i] = 1;
            }
            cells = arr;
        }
        return cells;
    }
}