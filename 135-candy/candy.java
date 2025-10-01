class Solution {
    public int candy(int[] rating) {
        int n = rating.length;
        int[] c = new int[n];
        Arrays.fill(c, 1);
        for(int i=1; i<n; i++){
            if(rating[i] > rating[i-1]){
                c[i] = c[i-1]+1;
            }
        }

        for(int i=n-2; i>=0; i--){
            if(rating[i] > rating[i+1]){
                c[i] = Math.max(c[i],c[i+1]+1);
            }
        }
        int min = 0;
        for(int i: c)
            min += i;
        
        return min;
    }
}