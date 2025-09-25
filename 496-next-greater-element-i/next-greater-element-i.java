class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            mp.put(nums1[i],i);
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums2.length; i++){
            while(!st.isEmpty() &&  nums2[i] > st.peek()){
                int ele = st.pop();
                if(mp.containsKey(ele)){
                    int idx = mp.get(ele);
                    ans[idx] = nums2[i];
                }
            }
            st.push(nums2[i]);
        }
        for(int i=0; i<nums1.length; i++){
            if(ans[i] == 0) ans[i] = -1;
        }
        return ans;
    }
}