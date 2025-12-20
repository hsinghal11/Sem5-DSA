class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int ans = -1;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(i == j) continue;
                int hours = arr[i]*10+arr[j];
                if(hours > 23) continue;

                for(int k=0; k<4; k++){
                    if(i==k || j==k) continue;

                    int l = 6-(i+j+k);
                    int min = arr[k]*10+arr[l];
                    if(min > 59) continue;

                    int totalMin = hours*60 + min;
                    ans = Math.max(ans, totalMin);
                }
            }
        }
        if (ans == -1) return "";
        return String.format("%02d:%02d", ans/60, ans%60);
    }
}