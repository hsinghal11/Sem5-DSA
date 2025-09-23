class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long l = 0;
        long r = (long)1e12;
        long ans = 0;
        while(l<=r){
            long m = l + (r-l)/2;
            long c = count(coins, m);
            if(c < k){
                l = m +1;
            }else{
                ans = m;
                r = m-1;
            }
        }
        return ans;
    }
    public long count(int[] coins, long m){
        int n = coins.length;
        int allones = (1<<n)-1;
        long cnt = 0;
        for(int i=1; i<=allones; i++){
            long Lcm = 1;
            for(int j=0; j<n; j++){
                if((i & (1<<j)) > 0)
                    Lcm = calculateLCM(Lcm, coins[j]);
            }
            if( (Long.bitCount(i) & 1) > 0){
                cnt += m/Lcm;
            }else{
                cnt -= m/Lcm;
            }
        }
        return cnt;
    }
    public long calculateLCM(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}