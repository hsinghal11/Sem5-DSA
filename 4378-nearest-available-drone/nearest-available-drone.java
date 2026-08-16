class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int ans = -1;
        int dis = Integer.MAX_VALUE;
        int i = 0;
        for(int[] arr: drones){
            int d = Math.abs(arr[0] - target[0]) + Math.abs(arr[1] - target[1]);
            if(d < dis && d <= arr[2]) {
                dis = d;
                ans = i;
            }
            i++;
        }
        return ans;
    }
}