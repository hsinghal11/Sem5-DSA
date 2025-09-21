class Solution {
    private boolean isValid(String s, String t, int mid, int[] start) {
        int[] need = new int[128];
        int distinct = 0;

        for (char c : t.toCharArray()) {
            if (need[c] == 0) distinct++;
            need[c]++;
        }

        int[] window = new int[128];
        int currCount = 0;

        // First window of size mid
        for (int i = 0; i < mid && i < s.length(); i++) {
            char c = s.charAt(i);
            window[c]++;
            if (window[c] == need[c]) currCount++;
        }
        if (currCount == distinct) {
            start[0] = 0;
            return true;
        }

        // Slide window across s
        for (int i = mid; i < s.length(); i++) {
            char add = s.charAt(i);
            char remove = s.charAt(i - mid);

            window[add]++;
            if (window[add] == need[add]) currCount++;

            if (window[remove] == need[remove]) currCount--;
            window[remove]--;

            if (currCount == distinct) {
                start[0] = i - mid + 1;
                return true;
            }
        }
        return false;
    }

    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if (m > n) return "";

        int low = m, high = n;
        int minLen = Integer.MAX_VALUE;
        int[] start = new int[1];
        String ans = "";

        // Binary search over possible window size
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(s, t, mid, start)) {
                if (mid < minLen) {
                    minLen = mid;
                    ans = s.substring(start[0], start[0] + mid);
                }
                high = mid - 1; // try smaller
            } else {
                low = mid + 1; // need bigger
            }
        }
        return ans;
    }
}
