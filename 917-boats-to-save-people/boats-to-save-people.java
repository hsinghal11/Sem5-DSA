class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0; 
        int j = n-1;
        int cnt = 0;
        while(i<=j){
            if(people[j] == limit){
                cnt++;
                j--;
            }else if(people[j] + people[i] >limit){
                cnt++;
                j--;
            }else{
                cnt++;
                j--;
                i++;
            }
        }
        return cnt;
    }
}