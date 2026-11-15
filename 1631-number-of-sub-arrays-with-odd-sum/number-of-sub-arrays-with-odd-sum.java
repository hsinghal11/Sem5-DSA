class Solution {
    public int numOfSubarrays(int[] arr) {
        int peven = 1;
        int podd = 0;
        int ans = 0;
        int sum = 0;

        int MOD = 1_000_000_007;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if ((sum & 1) == 0) {
                ans = (ans + podd) % MOD;
                peven++;
            } else {
                ans = (ans + peven) % MOD;
                podd++;
            }
        }

        return ans;
    }
}