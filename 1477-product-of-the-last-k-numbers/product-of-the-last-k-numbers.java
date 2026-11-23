class ProductOfNumbers {
    private ArrayList<Integer> arr;
    public ProductOfNumbers() {
        arr = new ArrayList<>();
        arr.add(1);
    }
    
    public void add(int num) {
        if(num == 0) {
            arr.clear();
            arr.add(1);
        }
        else arr.add(num * arr.get(arr.size()-1));
    }
    
    public int getProduct(int k) {
        if(k >= arr.size()) return 0;
        else return arr.get(arr.size()-1) / arr.get(arr.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */