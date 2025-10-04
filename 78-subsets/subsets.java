class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        solve(nums, new ArrayList<Integer>(), 0, ll);
        return ll;
    }
    public void solve(int[] nums,List<Integer> l, int idx, List<List<Integer>> ll){
            ll.add(new ArrayList<>(l));
        for(int i=idx; i<nums.length; i++){
            l.add(nums[i]);
            solve(nums, l, i+1, ll);
            l.remove(l.size()-1);
        }
    }
}