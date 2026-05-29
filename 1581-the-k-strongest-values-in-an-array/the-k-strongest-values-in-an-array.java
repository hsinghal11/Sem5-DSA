class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n-1)/2];
        int[][] indexArr = new int[n][2];

        for(int i=0; i<n; i++){
            indexArr[i][0] = Math.abs(arr[i]-m);
            indexArr[i][1] = arr[i];
        }

        Arrays.sort(indexArr, (a,b) -> {
            if(a[0] == b[0]) return b[1]-a[1];
            return b[0]-a[0];
        });
        
        int[] ans = new int[k];

        for(int i=0; i<k; i++){
            ans[i] = indexArr[i][1];
        }

        return ans;
    }
}