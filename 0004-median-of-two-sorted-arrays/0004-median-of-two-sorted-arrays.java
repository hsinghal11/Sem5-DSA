class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return solution(nums1,nums2);
    }
    public static double solution(int[] nums1, int[] nums2){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] newArr = new int[nums1.length+ nums2.length];
        while (i!= nums1.length && j!= nums2.length){
            if(nums1[i]<nums2[j]){
                newArr[k++] = nums1[i++];
            } else {
                newArr[k++]=nums2[j++];
            }
        }
        for (int l = i; l < nums1.length; l++) {
            newArr[k++] = nums1[l];
        }

        for (int m = j; m < nums2.length; m++) {
            newArr[k++] = nums2[m];
        }
//        System.out.println(Arrays.toString(newArr));

        double ans = 0;
        if(newArr.length%2!=0) return newArr[(newArr.length-1)/2];
        else {
            ans = (newArr[(newArr.length)/2] + newArr[(newArr.length)/2 - 1])/2.0;
        }
        return ans;
    }
}