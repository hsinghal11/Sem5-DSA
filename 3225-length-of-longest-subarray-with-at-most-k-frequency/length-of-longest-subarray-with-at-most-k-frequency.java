class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = -1;
        int si=0, ei=0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (ei < n){
            int ele = nums[ei];
            map.put(ele, map.getOrDefault(ele, 0)+1);
            
            while (map.get(ele) > k){
                int rele = nums[si];
                map.put(rele, map.get(rele)-1);
                si++;
            }
            
            ans = Math.max(ans, ei-si+1);
            ei++;
        }
        return ans;
    }
}