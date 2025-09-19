class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int arr[] = new int [nums[nums.length-1]+1];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int dif = Math.abs(nums[i]-nums[j]);
                arr[dif]++;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(k-arr[i]<=0){
                return i;
            }
            k-=arr[i];
        }
        return 0;
    }
}