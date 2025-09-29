class Solution {
    public int largestRectangleArea(int[] heights) {
        return Largest_Histogram(heights);
    }
     public int Largest_Histogram(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int h = arr[st.pop()];
                int r = i;
                if(st.isEmpty()){
                    max = Math.max(max, h*r);
                }else{
                    int w = r-st.peek()-1;
                    max = Math.max(max, h*w);
                }
            }
            st.push(i);
        }
        int r = arr.length;
        while(!st.isEmpty()){
            int h = arr[st.pop()];
                if(st.isEmpty()){
                    max = Math.max(max, h*r);
                }else{
                    int w = r-st.peek()-1;
                    max = Math.max(max, h*w);
                }
        }
        return max;
    }
}