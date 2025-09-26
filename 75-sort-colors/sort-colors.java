class Solution {
    public void sortColors(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0)c1++;
            if(nums[i] == 1)c2++;
            if(nums[i] == 2)c3++;
        }
        int i = 0;
            while(c1 != 0){
                nums[i] = 0;
                c1--;
                i++;
            }while(c2 != 0){
                nums[i] = 1;
                c2--;
                i++;
            }while(c3 != 0){
                nums[i] = 2;
                i++;
                c3--;
            }
        
    }
}