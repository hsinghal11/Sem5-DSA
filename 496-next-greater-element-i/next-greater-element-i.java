class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] freq = new int[11111];
        for(int i=0; i<nums2.length; i++){
            freq[nums2[i]] = i;
        }
        for(int i=0; i<nums1.length; i++){
            boolean flag = true;
            for(int j=freq[nums1[i]]; j<nums2.length; j++){
                if(nums2[j] > nums2[freq[nums1[i]]]){
                    nums1[i] = nums2[j];
                    flag = !flag;
                    break;
                }
            }
            if(flag)
            nums1[i] = -1;
        }
        return nums1;
    }
}