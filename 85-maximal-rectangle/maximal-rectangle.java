class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int[] arr = new int[matrix[0].length];
        for(char[] a: matrix){
            for(int i=0; i<a.length; i++){
                if(a[i] == '0'){
                    arr[i] = 0;
                }else{
                    arr[i] += 1;
                }
            }
            ans = Math.max(ans, Largest_Histogram(arr));
        }
        return ans;

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