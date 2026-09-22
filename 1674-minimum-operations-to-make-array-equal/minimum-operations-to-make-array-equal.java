class Solution {
    public int minOperations(int n) {
        int mid = ((2*(n-1)/2) + 1 + (2* (n/2))+1)/2;
        int ans = 0;
        int t;
        if((n & 1) != 1) ans++;
        for(int i=1; i<mid-1; i+=2){
            ans += (mid - i);
        }
        return ans;   
    }
}