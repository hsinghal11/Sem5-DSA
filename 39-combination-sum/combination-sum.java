class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= target; i++) dp.add(new ArrayList<>());

        dp.get(0).add(new ArrayList<>()); // base case: one way to make 0

        for (int num : candidates) {
            for (int sum = num; sum <= target; sum++) {
                for (List<Integer> comb : dp.get(sum - num)) {
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(num);
                    dp.get(sum).add(newComb);
                }
            }
        }

        return dp.get(target);
    }
}