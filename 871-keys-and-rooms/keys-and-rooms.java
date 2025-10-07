class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVis = new boolean[rooms.size()];
        Depth_First_Search(rooms, 0, isVis);
        for(boolean visited: isVis){
            if(!visited) return false;
        }
        return true;
    }

    public void Depth_First_Search(List<List<Integer>> rooms, int idx, boolean[] isVis){
        if(isVis[idx]) return;

        isVis[idx] = true;
        // System.out.println(rooms.get(idx)); // [1,4]
        for(int i: rooms.get(idx)){
            // System.out.println(i); // 1 then 4
            if(!isVis[i]){
                Depth_First_Search(rooms, i, isVis);
            }
        }

    }
}