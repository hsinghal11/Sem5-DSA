class Solution {
    public String largestNumber(int[] nums) {
        String[] no = new String[nums.length];
        for(int i = 0; i<nums.length; i++){
            no[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(no, (a,b)-> (b+a).compareTo(a+b));

        if (no[0].equals("0")) return "0";

        StringBuilder ans = new StringBuilder();
        for (String s : no) {
            ans.append(s);
        }

        return ans.toString();

    }
}