class Solution {
    public int[] twoSum(int[] nums, int target) {
        return sum(nums,target,nums.length);
    }
    public static int[] sum(int[] arr, int target, int n) {
        int[] temp = arr.clone();
        Arrays.sort(arr);
        int i = 0;
//        System.out.println(Arrays.toString(temp));
//        System.out.println(Arrays.toString(arr));
        int j = temp.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == target) {
                break;
            } else if (arr[i] + arr[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        int[] ans = new int[2];
        for (int k = 0; k < n; k++) {
            if(temp[k] == arr[i]) ans[0]=k;
        }
        for (int k = 0; k < n; k++) {
            if(temp[k]==arr[j] && k!=ans[0] ) ans[1]=k;
        }
        return ans;
    }
}