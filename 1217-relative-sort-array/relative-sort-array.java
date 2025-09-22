class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[10001];
        int[] ans = new int[arr1.length];
        for(int i=0; i<arr1.length; i++){
            arr[arr1[i]]++;
        }
        int k = 0; 
        for(int i=0; i<arr2.length; i++){
            if(arr[arr2[i]] > 0){
                int times = arr[arr2[i]];
                for(int j=k; j<k+times; j++){
                    ans[j] = arr2[i];
                }
                arr[arr2[i]] = 0;
                k+=times;
            }
        }
        for(int i=0; i<arr.length; i++){
            while(arr[i]-- >0){
                ans[k++] = i;
            }
        }
        return ans;
    }
}