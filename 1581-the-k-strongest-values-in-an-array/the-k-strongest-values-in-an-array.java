class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n-1)/2];
        
        int[] ans = new int[k];

        int i=0, j=n-1;

        for(int id =0; id<k; id++){
            if(Math.abs(arr[i] - m) > Math.abs(arr[j] - m)){
                ans[id] = arr[i++];
            }else if(Math.abs(arr[i] - m) < Math.abs(arr[j] - m)){
                ans[id] = arr[j--];
            }else{
                ans[id] = arr[i] > arr[j]? arr[i++]: arr[j--];
            }
        }

        return ans;
    }
}