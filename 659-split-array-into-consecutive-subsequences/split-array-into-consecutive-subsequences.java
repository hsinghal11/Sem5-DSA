class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer>present = new HashMap<>();
        HashMap<Integer,Integer>want = new HashMap<>();

        for(int i : nums){
            present.put(i, present.getOrDefault(i,0)+1);
        }

        for(int i : nums){
            if(present.getOrDefault(i,0)==0){
                continue;
            }
            if(want.getOrDefault(i,0)>0){
                want.put(i,want.get(i)-1);
                want.put(i+1,want.getOrDefault(i+1,0)+1);
                present.put(i,present.get(i)-1);
            }
            else if (present.getOrDefault(i+1,0)>0 && present.getOrDefault(i+2,0)>0){
                want.put(i+3,want.getOrDefault(i+3,0)+1);
                present.put(i,present.get(i)-1);
                present.put(i+1,present.get(i+1)-1);
                present.put(i+2,present.get(i+2)-1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}