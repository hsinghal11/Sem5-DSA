class RecentCounter {
    private ArrayList<Integer> ll; 
    public RecentCounter() {
        ll = new ArrayList<>();
    }
    
    public int ping(int t) {
        ll.add(t);
        int c = 0;
        for(int i=ll.size()-1; i>=0; i--){
            if(ll.get(i) <= t && ll.get(i) >= t-3000){
                c++;
            }
        }
        return c;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */