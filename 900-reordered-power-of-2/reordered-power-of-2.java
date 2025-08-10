class Solution {
    public boolean reorderedPowerOf2(int n) {
        String val = sortDigits(n);
        for (int i=0;i<=30;i++) {
            int ans = 1<<i;
            if (sortDigits(ans).equals(val)) {
                return true;
            }
        }
        return false;
    }
    public String sortDigits(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}