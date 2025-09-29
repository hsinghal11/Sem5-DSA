class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> ans = new ArrayList<>();
        int minc = 0, minr = 0, maxc = arr[0].length - 1, maxr = arr.length - 1;
        int toatalElement = arr.length * arr[0].length;
        int c = 0;
        while (c < toatalElement) {
            for (int i = minc; i <= maxc && c < toatalElement; i++) {
                ans.add(arr[minr][i]);
                c++;
            }
            minr++;
            for (int i = minr; i <= maxr && c < toatalElement; i++) {
                ans.add(arr[i][maxc]);
                c++;

            }
            maxc--;
            for (int i = maxc; i >= minc && c < toatalElement; i--) {
                ans.add(arr[maxr][i]);
                c++;

            }
            maxr--;
            for (int i = maxr; i >= minr && c < toatalElement ; i--) {
                ans.add(arr[i][minc]);
                c++;

            }
            minc++;
        }
        return ans;
    }
}