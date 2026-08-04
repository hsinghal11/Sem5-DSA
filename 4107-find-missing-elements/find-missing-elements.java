class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length-1; i++){
            int temp = nums[i];
            while(temp+1 < nums[i+1]){
                temp++;
                ans.add(temp);
            }
        }
        return ans;
    }
}