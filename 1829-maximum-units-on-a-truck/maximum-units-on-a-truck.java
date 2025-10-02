class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->Integer.compare(b[1], a[1]));
        for(int[] a: boxTypes){
            System.out.println(Arrays.toString(a));
        }
        int ans = 0;
        for(int i=0; i<boxTypes.length && truckSize > 0; i++){
            if(boxTypes[i][0] <= truckSize){
                ans+= boxTypes[i][0]*boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }else{
                int left = truckSize;
                ans += left*boxTypes[i][1];
                truckSize = 0;
            }
        }
        return ans;
    }
}