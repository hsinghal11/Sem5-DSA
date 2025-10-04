class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        solve(nums, new ArrayList<Integer>(), 0, ll);
        return ll;
    }
    public void solve(int[] nums,List<Integer> l, int idx, List<List<Integer>> ll){
        if(idx == nums.length){
            ll.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[idx]);
        solve(nums, l, idx+1, ll);
        l.remove(l.size()-1);
        solve(nums, l, idx+1, ll);

    }
}