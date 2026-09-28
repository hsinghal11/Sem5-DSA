class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
            solve(n, k, 1, new ArrayList<>());
        
        return ans;
    }

    private void solve(int n, int k, int ele, ArrayList<Integer> temp){
        if(k == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(ele > n) return;

        for (int i = ele; i <= n; i++) {
            temp.add(i);
            solve(n, k-1, i+1, temp);
            temp.removeLast();
        }
    }
}