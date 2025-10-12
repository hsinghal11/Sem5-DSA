class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> l = new ArrayList<>();
        solve(candidates, target, ans, l, 0);
        return ans;
    }

    public void solve(int[] candidates, int target, List<List<Integer>> ans, List<Integer> l, int idx){
        if(target == 0){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=idx; i<candidates.length; i++){
            if(i>idx && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target) break; // pruning

            l.add(candidates[i]);
            solve(candidates, target - candidates[i], ans, l, i+1);
            l.removeLast();
        }
    }
}