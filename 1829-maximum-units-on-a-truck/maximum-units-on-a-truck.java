class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->Integer.compare(b[1], a[1]));
        int ans=0;
        int index=0;
        while(truckSize>0 && index<boxTypes.length){
             ans+=Math.min(truckSize,boxTypes[index][0])*boxTypes[index][1];
            truckSize-=boxTypes[index][0];
            index++;
        }
        return ans;
    }
}