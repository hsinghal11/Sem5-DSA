class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] f = {0, 0, 0};

        for(int i: stones){
            f[i%3]++;
        }

        if(f[0] %2 == 0) return f[1] >0 && f[2] > 0;

        return Math.abs(f[1] - f[2]) > 2; 
    }
}