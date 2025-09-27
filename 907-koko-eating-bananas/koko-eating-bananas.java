import java.util.*;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        int lo = 1;
        int hi = Arrays.stream(piles).max().getAsInt();
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(isitpossible(piles,mid,h)){
                k = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return k;
    }
    public static boolean isitpossible(int [] arr, int mid, int h){
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            ans += (arr[i]+mid-1)/mid;
            if(ans > h) return false;
        }
        return true;
    }
}