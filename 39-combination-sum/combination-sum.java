class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        solve(candidates, target, ans, l, 0);
        return ans;
    }

    public void solve(int[] candidates, int target, List<List<Integer>> ans, List<Integer> l, int idx){
        if(target == 0){
            ans.add(new ArrayList<>(l));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i=idx; i<candidates.length; i++){
            l.add(candidates[i]);
            solve(candidates, target - candidates[i], ans, l, i);
            l.removeLast();
        }
        
    }
}